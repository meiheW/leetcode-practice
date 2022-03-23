//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 985 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-02 23:43:06
 */
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] arr = new int[]{2, 0, 0};
        solution.canJump(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean canJump(int[] nums) {
            if (nums.length <= 1) {
                return true;
            }
            int n = nums.length;
            int right = 0;
            for (int i = 0; i < n; i++) {
                if (i <= right) {
                    right = Math.max(right, i + nums[i]);
                    if (right >= n - 1) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            return false;

        }

        /**
         * 找到0的位置，看他前面有没有能跨越过去的，有就可以，没有就不能走到最后一个
         *
         * @param nums
         * @return
         */
        public boolean canJump2(int[] nums) {
            if (nums == null) {
                return false;
            } else if (nums.length == 1) {
                return true;
            }
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] == 0) {
                    boolean f = false;
                    for (int j = 0; j <= i - 1; j++) {
                        if (nums[j] + j > i) {
                            f = true;
                            break;
                        }
                    }
                    if (!f) {
                        return false;
                    }

                }
            }
            return true;

        }


        /**
         * 拿到之后想出来的第一种，遍历一次，O(N^2)
         *
         * @param nums
         * @return
         */
        public boolean canJump_1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            boolean[] mark = new boolean[nums.length];
            mark[0] = true;
            for (int i = 0; i < nums.length; i++) {
                if (mark[i]) {
                    int step = nums[i];
                    int j = i;
                    while (step-- != 0 && ++j < nums.length) {
                        mark[j] = true;
                    }
                } else {
                    break;
                }
            }
            return mark[nums.length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}