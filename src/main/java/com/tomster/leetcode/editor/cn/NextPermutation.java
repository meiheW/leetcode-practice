//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
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
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组
// 👍 875 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: tomster
 * @data: 2020-12-20 16:54:42
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 讲一下整体思想：
         * 下一个比当前排列大的排列，应该是从右到左找到变小的那个数字index = i（因为从右向左数字变大没法换，换了之后肯定是变小）
         * 在它找比他大且离他最近的那个数index = j，两个数交换位置，交换位置后，将i右边的数从小到大排列
         * 特例：如果整个数字原先就是逆序排列，就将数组颠倒一下。
         *
         * @param nums
         */
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int index = -1;
            for (int i = nums.length - 1; i >= 1; i--) {
                if (nums[i - 1] < nums[i]) {
                    index = i - 1;
                    break;
                }
            }
            if (index == -1) {
                //如果数组是递减排序的，翻转数组
                reverse(nums);
            } else {
                int target = nums.length - 1;
                for (int j = index + 1; j < nums.length; j++) {
                    if (nums[j] <= nums[index]) {
                        target = j - 1;
                        break;
                    }
                }
                //交换index和target下标的两个数字
                swap(nums, index, target);
                //index后面的元素从小打到排列
                Arrays.sort(nums, index + 1, nums.length);
            }


        }

        private void reverse(int[] nums) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, nums.length - i - 1);
            }
        }

        private void swap(int[] nums, int index, int target) {
            int temp = nums[index];
            nums[index] = nums[target];
            nums[target] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}