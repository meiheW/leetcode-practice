//我们称一个分割整数数组的方案是 好的 ，当它满足：
//
//
// 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
// left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
//
//
// 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1]
//输出：1
//解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,2,2,5,0]
//输出：3
//解释：nums 总共有 3 种好的分割方案：
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
//
//
// 示例 3：
//
//
//输入：nums = [3,2,1]
//输出：0
//解释：没有好的分割方案。
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 105
// 0 <= nums[i] <= 104
//
// Related Topics 数组 双指针 二分查找 前缀和
// 👍 61 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-21 16:06:31
 */
public class WaysToSplitArrayIntoThreeSubarrays {
    public static void main(String[] args) {
        Solution solution = new WaysToSplitArrayIntoThreeSubarrays().new Solution();
        int i = solution.waysToSplit(new int[]{0, 3, 3});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToSplit(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            int sum = preSum[n];
            long ans = 0;

            for (int i = 1; i < n + 1 && preSum[i] <= sum / 3; i++) {
                int sum0 = preSum[i];
                int sum1Min = 2 * sum0;
                int sum1Max = sum0 + (sum - sum0) / 2;
                int left = lowerBound(i + 1, n, preSum, sum1Min);
                int right = upperBound(i + 1, n, preSum, sum1Max);
                if (right >= left) {
                    ans += (long) right - left + 1;
                }
            }
            return (int) (ans % 1_000_000_007);
        }

        private int upperBound(int low, int high, int[] nums, int target) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                //target的最右边一个
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

        private int lowerBound(int low, int high, int[] nums, int target) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                //target的最左边一个
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        //前缀和+ 二分
        //思路是对的，但是二分实际做的有点问题
        public int waysToSplit1(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            int sum = preSum[n];
            int p0 = 1;
            int ans = 0;
            //sum0 (p0) sum1 (p1) sum2
            while (preSum[p0] <= sum / 3) {
                int sum0 = preSum[p0];
                int sum1Min = 2 * sum0;
                int sum1Max = sum0 + (sum - sum0) / 2;
                int index1 = Arrays.binarySearch(preSum, p0, n, sum1Min);
                //int index1 = Arrays.binarySearch(preSum, sum1Min);
                if (index1 < 0) {
                    index1 = -(1 + index1);
                }
                int index2 = Arrays.binarySearch(preSum, p0, n, sum1Max);
                //int index2 = Arrays.binarySearch(preSum, sum1Max);
                if (index2 < 0) {
                    index2 = -(1 + index2);
                    index2--;//不能包含插入位置的那一个，边界控制
                }
                if (index2 >= index1) {
                    ans += (index2 - index1 + 1);
                }
                p0++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}