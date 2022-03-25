//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
// Related Topics 数组 动态规划 
// 👍 593 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-25 15:24:31
 */
public class CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //动态规划，真牛逼
        public int combinationSum4(int[] nums, int target) {
            //dp[i]：和为i的方案数
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i >= num) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }


        int ans = 0;

        //输入：nums = [1,2,3], target = 4
        //输出：7
        //解释：(1, 1, 1, 1)(1, 1, 2)(1, 2, 1)
        //      (1, 3)(2, 1, 1)(2, 2)(3, 1)
        //回溯，超时
        public int combinationSum4_1(int[] nums, int target) {
            backTracing(nums, target);
            return ans;
        }

        private void backTracing(int[] nums, int target) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ans++;
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                backTracing(nums, target - nums[i]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}