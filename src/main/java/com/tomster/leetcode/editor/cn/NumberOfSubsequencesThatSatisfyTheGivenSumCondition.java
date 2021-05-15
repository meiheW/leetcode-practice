//给你一个整数数组 nums 和一个整数 target 。 
//
// 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。 
//
// 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,5,6,7], target = 9
//输出：4
//解释：有 4 个子序列满足该条件。
//[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,8], target = 10
//输出：6
//解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] 
//
// 示例 3： 
//
// 输入：nums = [2,3,3,4,6,7], target = 12
//输出：61
//解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
//有效序列总数为（63 - 2 = 61）
// 
//
// 示例 4： 
//
// 输入：nums = [5,2,4,1,7,6,8], target = 16
//输出：127
//解释：所有非空子序列都满足条件 (2^7 - 1) = 127 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 1 <= target <= 10^6 
// 
// Related Topics 排序 Sliding Window 
// 👍 54 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-05-15 22:59:36
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubseq(int[] nums, int target) {

            Arrays.sort(nums);
            if (nums[0] * 2 > target) {
                return 0;
            }
            int[] pows = new int[nums.length];
            pows[0] = 1;
            int base = (int) Math.pow(10, 9) + 7;
            for (int i = 1; i < pows.length; i++) {
                pows[i] = pows[i - 1] * 2;
                pows[i] %= base;
            }
            int low = 0;
            int high = nums.length - 1;
            long result = 0;
            while (low <= high) {
                if (nums[low] + nums[high] <= target) {
                    //统计结果
                    result += pows[high - low] % base;
                    result %= base;
                    low++;
                } else {
                    high--;
                }
            }
            return (int) (result % base);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}