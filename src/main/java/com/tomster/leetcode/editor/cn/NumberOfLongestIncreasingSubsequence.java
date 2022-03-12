//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -106 <= nums[i] <= 106 
// 
// Related Topics 树状数组 线段树 数组 动态规划 
// 👍 566 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2022-03-12 09:34:15
 */
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {

            int n = nums.length;
            if (n == 1) {
                return 1;
            }
            //dp[i]表示以nums[i]结尾的最长子序列长度
            int[] dp = new int[n];
            //count[i]表示以nums[i]结尾的最长子序列长度的数量
            int[] count = new int[n];
            Arrays.fill(dp, 1);
            Arrays.fill(count, 1);
            int maxLen = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j];
                        } else if (dp[j] + 1 > dp[i]) {
                            count[i] = count[j];
                            dp[i] = dp[j] + 1;
                        }
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (maxLen == dp[i]) {
                    ans += count[i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}