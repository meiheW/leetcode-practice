/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是
 * 18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * Related Topics 数学 动态规划 👍 208 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-04 17:16:56
 */
public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            if (n <= 3) return n - 1;
            int b = n % 3, p = 1000000007;
            long rem = 1, x = 3;
            for (int a = n / 3 - 1; a > 0; a /= 2) {
                if (a % 2 == 1) rem = (rem * x) % p;
                x = (x * x) % p;
            }
            if (b == 0) return (int) (rem * 3 % p);
            if (b == 1) return (int) (rem * 4 % p);
            return (int) (rem * 6 % p);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}