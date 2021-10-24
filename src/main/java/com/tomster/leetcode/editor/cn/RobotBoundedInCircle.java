//在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一： 
//
// 
// "G"：直走 1 个单位 
// "L"：左转 90 度 
// "R"：右转 90 度 
// 
//
// 机器人按顺序执行指令 instructions，并一直重复它们。 
//
// 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 输入："GGLLGG"
//输出：true
//解释：
//机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
//重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
// 
//
// 示例 2： 
//
// 输入："GG"
//输出：false
//解释：
//机器人无限向北移动。
// 
//
// 示例 3： 
//
// 输入："GL"
//输出：true
//解释：
//机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。 
//
// 
//
// 提示： 
//
// 
// 1 <= instructions.length <= 100 
// instructions[i] 在 {'G', 'L', 'R'} 中 
// 
// Related Topics 数学 字符串 模拟 
// 👍 94 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-10-24 21:00:31
 */
public class RobotBoundedInCircle {
    public static void main(String[] args) {
        Solution solution = new RobotBoundedInCircle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isRobotBounded(String instructions) {
            int x = 0, y = 0;
            int direction = 0;//0,1,2,3分别代表北方向顺时转动的四个方向
            //G.L.R代表走，左转，右转
            while (true) {
                for (char c : instructions.toCharArray()) {
                    if (c == 'L') {
                        direction = (direction - 1 + 4) % 4;
                    } else if (c == 'R') {
                        direction = (direction + 1 + 4) % 4;
                    } else {
                        if (direction == 0) {
                            y++;
                        } else if (direction == 1) {
                            x++;
                        } else if (direction == 2) {
                            y--;
                        } else if (direction == 3) {
                            x--;
                        }
                    }
                }
                if (direction == 0) {
                    break;
                }
            }
            return x == 0 && y == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}