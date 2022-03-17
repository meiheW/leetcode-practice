//集团里有 n 名员工，他们可以完成各种各样的工作创造利润。 
//
// 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。 
//
// 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。 
//
// 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
//输出：2
//解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
//总的来说，有两种计划。 
//
// 示例 2： 
//
// 
//输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
//输出：7
//解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
//有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。 
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= minProfit <= 100 
// 1 <= group.length <= 100 
// 1 <= group[i] <= 100 
// profit.length == group.length 
// 0 <= profit[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 232 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-17 17:40:35
 */
public class ProfitableSchemes {
    public static void main(String[] args) {
        Solution solution = new ProfitableSchemes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
        //输出：2
        //解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
        //总的来说，有两种计划。
        public int profitableSchemes1(int n, int minProfit, int[] group, int[] profit) {
            int nGroup = group.length, MOD = (int) Math.pow(10, 9) + 7;
            //dp[i][j][k]表示前i个工作，恰好人数为j，至少产生k利润的方案数
            int[][][] dp = new int[nGroup + 1][n + 1][minProfit + 1];
            dp[0][0][0] = 1;
            for (int i = 1; i <= nGroup; i++) {
                int members = group[i - 1], earn = profit[i - 1];
                for (int j = 0; j <= n; j++) {
                    for (int k = 0; k <= minProfit; k++) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j >= members) {
                            //如果当前i的在子集中，还要多加一项: dp[i - 1][j - members]k - earn]
                            dp[i][j][k] += dp[i - 1][j - members][Math.max(k - earn, 0)];
                            dp[i][j][k] %= MOD;
                        }
                    }
                }
            }
            //这个表示参与人数为n，实际问题应该是至多n个员工，不一定都要用
            //return dp[nGroup][n][minProfit];
            int ans = 0;
            for (int j = 0; j <= n; j++) {
                ans = (ans + dp[nGroup][j][minProfit]) % MOD;
            }
            return ans;
        }

        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            int nGroup = group.length, MOD = (int) Math.pow(10, 9) + 7;
            //dp[i][j][k]表示前i个工作，人数至多为j，至少产生k利润的方案数
            //dp与上面一个含义不同，初始化边界赋值也不一样
            int[][][] dp = new int[nGroup + 1][n + 1][minProfit + 1];
            for (int j = 0; j <= n; j++) {
                dp[0][j][0] = 1;
            }
            for (int i = 1; i <= nGroup; i++) {
                int members = group[i - 1], earn = profit[i - 1];
                for (int j = 0; j <= n; j++) {
                    for (int k = 0; k <= minProfit; k++) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j >= members) {
                            //如果当前i的在子集中，还要多加一项: dp[i - 1][j - members]k - earn]
                            dp[i][j][k] += dp[i - 1][j - members][Math.max(k - earn, 0)];
                            dp[i][j][k] %= MOD;
                        }
                    }
                }
            }
            return dp[nGroup][n][minProfit];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}