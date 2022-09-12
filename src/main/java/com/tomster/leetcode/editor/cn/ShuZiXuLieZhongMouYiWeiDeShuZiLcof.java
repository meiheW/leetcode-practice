/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等
 * 。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 0 <= n < 2^31
 * <p>
 * <p>
 * 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 * Related Topics 数学 二分查找 👍 290 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-12 14:01:43
 */
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            int low = 1, high = 9;
            while (low < high) {
                int mid = low + (high - low) / 2;
                int digits = totalDigits(mid);
                //确定所在位数长度
                if (digits < n) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int preCount = totalDigits(high - 1);
            int index = n - preCount - 1;
            int start = (int) Math.pow(10, high - 1);
            int num = start + index / high;
            int digit = index % high;//0.1.2
            //取num的index%high位数
            return (num / ((int) Math.pow(10, high - digit - 1))) % 10;
        }

        private int totalDigits(int len) {
            int ans = 0;
            int curLen = 1, cnt = 9;
            while (curLen <= len) {
                ans += curLen * cnt;
                curLen++;
                cnt *= 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}