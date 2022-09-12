/**
 * /**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 12
 * 输出：5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 13
 * 输出：6
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= n < 2^31
 * <p>
 * <p>
 * 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 * Related Topics 递归 数学 动态规划 👍 368 👎 0
 */

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-12 16:24:03
 */
public class OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int digit = 1, res = 0;
            int high = n / 10, cur = n % 10, low = 0;
            while (high != 0 || cur != 0) {
                if (cur == 0) {
                    res += high * digit;
                } else if (cur == 1) {
                    res += high * digit + low + 1;
                } else {
                    res += (high + 1) * digit;
                }
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}