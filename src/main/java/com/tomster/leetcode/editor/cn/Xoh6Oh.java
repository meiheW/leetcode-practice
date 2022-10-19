/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 2³¹−1]。本题中，如果除法结果溢出，则返回 231 − 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：a = 0, b = 1
 * 输出：0
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：a = 1, b = 1
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * -2³¹ <= a, b <= 2³¹ - 1
 * b != 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/
 * <p>
 * <p>
 * Related Topics 位运算 数学 👍 194 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 08:58:59
 */
public class Xoh6Oh {
    public static void main(String[] args) {
        Solution solution = new Xoh6Oh().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int a, int b) {
            int sign = 1;
            if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
                sign = -1;
            }
            long ldividend = Math.abs((long) a);
            long ldivisor = Math.abs((long) b);
            long result = ldivide(ldividend, ldivisor);
            if (result > Integer.MAX_VALUE) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                return (int) (sign * result);
            }
        }

        private long ldivide(long ldividend, long ldivisor) {
            //递归结束条件
            if (ldividend < ldivisor) {
                return 0;
            }
            long sum = ldivisor;
            long count = 1;
            //指数级求和
            while (sum + sum <= ldividend) {
                sum += sum;
                count += count;
            }
            return count + ldivide(ldividend - sum, ldivisor);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}