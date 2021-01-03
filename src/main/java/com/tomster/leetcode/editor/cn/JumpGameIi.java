//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 789 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-03 14:31:19
 */
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        int[] arr = new int[]{2, 3, 1, 1, 4};
        int jump = solution.jump(arr);
        System.out.println(jump);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这一题标记为困难，一看这道题目思想上觉得应该用动态规划或者贪婪算法去做
         * 题解上面有dfs，bfs，最小路径算法(Dijkstra算法)等等
         * 下面是看了官方题解和几个有思路的答案的结果
         * <p>
         * 1.贪心策略：反向查找，每次都跳回能跳到该位置的最左边的元素
         * 时间复杂度O(N^2)，空间复杂度O(1)
         * 运行结果超时...
         *
         * @param nums
         * @return
         */
        public int jump_1(int[] nums) {
            int curPos = nums.length - 1;
            int step = 0;
            while (curPos > 0) {
                for (int i = 0; i < curPos; i++) {
                    if (nums[i] + i >= curPos) {
                        curPos = i;
                        step++;
                        break;
                    }
                }

            }
            return step;
        }


        /**
         * 正向贪婪算法，核心在于这一步的跳跃结果集中的每一个位置所能达到的下一个位置最远的那个
         * 为这一步要跳的位置，这样能保证贪婪算法能求出真正的准确值
         *
         * @param nums
         * @return
         */
        public int jump(int[] nums) {
            int curPos = 0;
            int steps = 0;
            int nextPos = 0;
            while (curPos < nums.length - 1) {
                //这一跳能到终点，返回step+1
                if (curPos + nums[curPos] >= nums.length - 1) {
                    return steps + 1;
                } else {
                    int max = 0;
                    for (int i = curPos + 1; i <= curPos + nums[curPos]; i++) {
                        if (i + nums[i] > max) {
                            max = i + nums[i];
                            nextPos = i;
                        }
                    }
                    steps++;
                    curPos = nextPos;
                }
            }
            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}