//给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。 
//
// 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。 
//
// 请你返回乘积为正数的最长子数组长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,-3,4]
//输出：4
//解释：数组本身乘积就是正数，值为 24 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,-2,-3,-4]
//输出：3
//解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
//注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3,0,1]
//输出：2
//解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// 
//
// 
// Related Topics 贪心 数组 动态规划 
// 👍 134 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-23 15:58:02
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfSubarrayWithPositiveProduct().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxLen(int[] nums) {
            int n = nums.length;
            //dp[i]表示以nums[i]结尾的成绩为正或者负的最长长度
            int[][] dp = new int[n][2];
            dp[0][0] = nums[0] > 0 ? 1 : 0;
            dp[0][1] = nums[0] < 0 ? 1 : 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] > 0) {
                    dp[i][0] = dp[i - 1][0] + 1;
                    if (dp[i - 1][1] != 0) {
                        dp[i][1] = dp[i - 1][1] + 1;
                    }
                } else if (nums[i] < 0) {
                    if (dp[i - 1][1] != 0) {
                        dp[i][0] = dp[i - 1][1] + 1;
                    }
                    dp[i][1] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = dp[i][1] = 0;
                }
            }
            int ans = dp[0][0];
            for (int i = 1; i < dp.length; i++) {
                ans = Math.max(ans, dp[i][0]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}