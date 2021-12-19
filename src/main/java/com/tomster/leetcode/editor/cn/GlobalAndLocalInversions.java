//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。 
//
// 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目： 
//
// 
// 0 <= i < j < n 
// nums[i] > nums[j] 
// 
//
// 局部倒置 的数目等于满足下述条件的下标 i 的数目： 
//
// 
// 0 <= i < n - 1 
// nums[i] > nums[i + 1] 
// 
//
// 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,2]
//输出：true
//解释：有 1 个全局倒置，和 1 个局部倒置。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,0]
//输出：false
//解释：有 2 个全局倒置，和 1 个局部倒置。
// 
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// 0 <= nums[i] < n 
// nums 中的所有整数 互不相同 
// nums 是范围 [0, n - 1] 内所有数字组成的一个排列 
// 
// Related Topics 数组 数学 
// 👍 78 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 16:01:39
 */
public class GlobalAndLocalInversions {
    public static void main(String[] args) {
        Solution solution = new GlobalAndLocalInversions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {//充要条件：Math.abs(nums[i] - i) <= 1

        public boolean isIdealPermutation(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                if (Math.abs(nums[i] - i) > 1) {
                    return false;
                }
            }
            return true;

        }

        /**
         * 我没有注意到[0,n-1]这个条件，不过我的解法比较通用
         */
        public boolean isIdealPermutation1(int[] nums) {
            int n = nums.length;
            //局部倒置全部修好
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    i += 1;
                }
            }
            //在遍历一遍，应该是升序的
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}