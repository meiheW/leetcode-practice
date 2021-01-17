//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 
//
// 示例 1: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
// 
//
// 示例 2: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false 
//
// 进阶: 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 271 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-17 21:39:09
 */
public class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {

            if (nums == null || nums.length == 0) {
                return false;
            }
            int left = 0;
            int right = nums.length - 1;
            //双指针,思想与二分查找类似
            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    return true;
                } else if (nums[left] < nums[middle]) {//左侧有序
                    if (nums[left] <= target && target < nums[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                } else if (nums[right] > nums[middle]) {//右侧有序
                    if (nums[middle] < target && target <= nums[right]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    //middle与left相等
                    while (left <= right && nums[left] == nums[middle])
                        left++;
                    while (left <= right && nums[right] == nums[middle])
                        right--;
                }

            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}