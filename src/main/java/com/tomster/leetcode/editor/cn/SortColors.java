//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意：请不要使用代码库中的排序函数来解决这道题。 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
// Related Topics 排序 数组 双指针 
// 👍 754 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-13 22:59:51
 */
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums = new int[]{2,0,2,1,1,0};
        solution.sortColors(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            //找到第一个不为0和最后一个不为2的数字
            int p1 = 0;
            while (p1 < nums.length && nums[p1] == 0) {
                p1++;
            }
            int p2 = nums.length - 1;
            while (p2 > -1 && nums[p2] == 2) {
                p2--;
            }
            if (p1 == p2 || p1 == nums.length || p2 == -1) {
                return;
            }
            int i = p1;
            while (i <= p2) {
                if (nums[i] == 1) {
                    i++;
                } else if (nums[i] == 0) {
                    swap(nums, i++, p1++);
                } else {
                    swap(nums, i, p2--);
                }
            }

        }


        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}