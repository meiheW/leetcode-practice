//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 1346 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 20:08:07
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int zeroCount = 0;
            for (int num : nums) {
                if (num == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == 0) {
                return;
            }
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }
            for (int i = 0; i < zeroCount; i++) {
                nums[nums.length - 1 - i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}