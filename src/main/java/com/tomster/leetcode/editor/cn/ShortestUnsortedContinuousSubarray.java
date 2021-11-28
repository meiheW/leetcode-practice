//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 737 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-28 11:56:19
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            if (nums == null && nums.length <= 1) {
                return 0;
            }
            int right = -1, max = Integer.MIN_VALUE;
            int left = -1, min = Integer.MAX_VALUE;
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                //右边界
                if (max > nums[i]) {
                    right = i;
                } else {
                    max = nums[i];
                }
                //左边界
                if (min < nums[n - 1 - i]) {
                    left = n - 1 - i;
                } else {
                    min = nums[n - 1 - i];
                }
            }

            return left == -1 ? 0 : right - left + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}