//请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。 
//
// 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。 
//
// 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：12
//解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
// 
//
// 示例 2： 
//
// 输入：n = 100
//输出：682289015
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学 
// 👍 35 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-12-07 22:26:50
 */
public class PrimeArrangements {
    public static void main(String[] args) {
        Solution solution = new PrimeArrangements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        final int BASE = 1000_000_007;

        public int numPrimeArrangements(int n) {
            int primeCount = countPrimes(n);
            long ans = 1;
            for (int i = 1; i <= primeCount; i++) {
                ans *= i;
                ans %= BASE;
            }
            for (int i = 1; i <= n - primeCount; i++) {
                ans *= i;
                ans %= BASE;
            }
            return (int) ans;
        }


        private int countPrimes(int n) {
            int ans = 0;
            int[] isPrimes = new int[n + 1];
            Arrays.fill(isPrimes, 1);
            for (int i = 2; i <= n; i++) {
                if (isPrimes[i] == 1) {
                    ans++;
                    if ((long) i * i <= n) {
                        for (int j = i * i; j <= n; j += i) {
                            isPrimes[j] = 0;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}