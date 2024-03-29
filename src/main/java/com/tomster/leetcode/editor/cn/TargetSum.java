//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 1103 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-12 17:39:22
 */
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：nums = [1,1,1,1,1], target = 3
        //输出：5
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int diff = sum - target;
            if (diff < 0 || diff % 2 == 1) {
                return 0;
            }
            int n = nums.length, sumNeg = diff / 2;
            //dp[i][j]表示前i个数组成和为j的子集的数量
            int[][] dp = new int[n + 1][sumNeg + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int num = nums[i - 1];
                for (int j = 0; j <= sumNeg; j++) {
                    dp[i][j] = dp[i - 1][j];
                    //包含num的子集的数量
                    if (num <= j) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
            return dp[n][sumNeg];
        }


        int ans = 0;

        //我开始用的回溯
        public int findTargetSumWays1(int[] nums, int target) {
            dfs(nums, 0, 0, target);
            return ans;
        }

        private void dfs(int[] nums, int sum, int index, int target) {
            if (index == nums.length) {
                if (sum == target) {
                    ans++;
                }
                return;
            }
            dfs(nums, sum + nums[index], index + 1, target);
            dfs(nums, sum - nums[index], index + 1, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}