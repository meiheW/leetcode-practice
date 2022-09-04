/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2⁻² = 1/2² = 1/4 = 0.25
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -100.0 < x < 100.0
 * -2³¹ <= n <= 2³¹-1
 * -10⁴ <= xⁿ <= 10⁴
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 * Related Topics 递归 数学 👍 347 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-04 17:21:55
 */
public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        double ans = solution.myPow(2, -2);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n > 0) {
                return pow(x, n);
            } else {
                return 1 / pow(x, -n);
            }
        }

        private double pow(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return x;
            }
            double d = pow(x, n / 2);
            return n % 2 == 0 ? d * d : d * d * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}