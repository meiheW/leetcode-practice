//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 310 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-04-30 11:57:42
 */
public class NthDigit {
    public static void main(String[] args) {
        Solution solution = new NthDigit().new Solution();
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