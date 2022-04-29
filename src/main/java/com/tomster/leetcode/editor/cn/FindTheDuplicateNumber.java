//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 
// 👍 1711 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-04-29 18:02:11
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findDuplicate(int[] nums) {
            int n = nums.length;
            int low = 1, high = n;
            int ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int cnt = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                    ans = mid;
                }
            }
            return ans;
        }

        //该方法修改数组，题目要求不修改数组
        public int findDuplicate1(int[] nums) {
            int p = 0;
            while (p < nums.length - 1) {
                while (nums[p] != p + 1) {
                    if (nums[p] == nums[nums[p] - 1]) {
                        return nums[p];
                    } else {
                        swap(nums, p, nums[p] - 1);
                    }
                }
                p++;
            }
            return nums[p];
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}