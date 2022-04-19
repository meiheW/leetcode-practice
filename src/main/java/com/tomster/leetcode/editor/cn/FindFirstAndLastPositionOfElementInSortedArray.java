//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 777 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2020-12-22 23:35:40
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int i = Arrays.binarySearch(nums, target);
            if (i < 0) {
                return new int[]{-1, -1};
            }
            //第一个出现的下标
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int middle = low + (high - low) / 2;
                if (nums[middle] >= target) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
            int first = low;
            //最后一个出现的下标
            low = 0;
            high = nums.length - 1;
            while (low <= high) {
                int middle = low + (high - low) / 2;
                if (nums[middle] > target) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
            int last = high;
            return new int[]{first, last};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}