//机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ： 
//
// 
// -2 ：向左转 90 度 
// -1 ：向右转 90 度 
// 1 <= x <= 9 ：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点 obstacles[i] = (xi, yi) 。 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ） 
//
// 
// 
// 
// 
// 
// 
//
// 
// 注意： 
//
// 
// 北表示 +Y 方向。 
// 东表示 +X 方向。 
// 南表示 -Y 方向。 
// 西表示 -X 方向。 
// 
// 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：commands = [4,-1,3], obstacles = []
//输出：25
//解释：
//机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 3 个单位，到达 (3, 4)
//距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25 
//
// 示例 2： 
//
// 
//输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出：65
//解释：机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
//4. 左转
//5. 向北走 4 个单位，到达 (1, 8)
//距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65 
//
// 
//
// 提示： 
//
// 
// 1 <= commands.length <= 104 
// commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9]. 
// 0 <= obstacles.length <= 104 
// -3 * 104 <= xi, yi <= 3 * 104 
// 答案保证小于 231 
// 
// Related Topics 数组 模拟 
// 👍 155 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-10-24 13:25:31
 */
public class WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {

            int direction = 0;//0,1,2,3代表N顺时针的四个方向
            int x = 0, y = 0;//当前位置的横纵坐标
            int ans = 0;//结果
            for (int command : commands) {
                if (command == -1) {
                    direction = (direction + 1) % 4;
                } else if (command == -2) {
                    direction = (direction - 1 + 4) % 4;
                } else {
                    //更新坐标
                    int[] pos = updatePositon(obstacles, x, y, direction, command);
                    x = pos[0];
                    y = pos[1];
                    ans = Math.max(ans, (int) Math.pow(x, 2) + (int) Math.pow(y, 2));
                }
            }
            return ans;
        }

        private int[] updatePositon(int[][] obstacles, int x, int y, int direction, int step) {
            int[] newPos = new int[2];
            if (direction == 0 || direction == 2) {
                int min = step;
                for (int[] obstacle : obstacles) {
                    if (obstacle[0] == x) {
                        //求机器人可以走的最小的步数
                        int gap = (obstacle[1] - y) * (1 - direction);
                        if (gap > 0) {
                            min = Math.min(min, gap - 1);
                        }
                    }
                }
                newPos[0] = x;
                newPos[1] = y + min * (1 - direction);
            } else if (direction == 1 || direction == 3) {
                int min = step;
                for (int[] obstacle : obstacles) {
                    if (obstacle[1] == y) {
                        int gap = (obstacle[0] - x) * (2 - direction);
                        if (gap > 0) {
                            min = Math.min(min, gap - 1);
                        }
                    }
                }
                newPos[0] = x + min * (2 - direction);
                newPos[1] = y;
            }
            return newPos;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}