//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2433 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-01 20:30:29
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            //单个处理特别麻烦，总结下来，基本用异常和long类型转换来做的


            int flag = x >= 0 ? 1 : -1;
            long x1 = (long) x;
            x1 = x >= 0 ? x1 : (-1) * x1;

            long result = 0;
            while (x1 != 0) {
                result = result * 10 + x1 % 10;
                x1 /= 10;
            }

            return result == (int) result ? (int) result * flag : 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}