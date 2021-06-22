//给定一个整数数组 asteroids，表示在同一行的行星。 
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 示例 4： 
//
// 
//输入：asteroids = [-2,-1,1,2]
//输出：[-2,-1,1,2]
//解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 104 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics 栈 
// 👍 154 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-06-22 22:49:37
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 两个行星相互碰撞，较小的行星会爆炸。
         * 如果两颗行星大小相同，则两颗行星都会爆炸。
         * 两颗移动方向相同的行星，永远不会发生碰撞。
         * 输入：asteroids = [5,10,-5]，输出：[5,10]
         * 输入：asteroids = [8,-8]，输出：[]
         * 输入：asteroids = [10,2,-5]，输出：[10]
         * 输入：asteroids = [-2,-1,1,2]，输出：[-2,-1,1,2]
         */
        public int[] asteroidCollision(int[] asteroids) {
            if (asteroids == null || asteroids.length == 0) {
                return asteroids;
            }
            Stack<Integer> stack = new Stack<>();
            for (int cur : asteroids) {
                if (cur < 0) {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + cur < 0) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(cur);
                    } else if (stack.peek() + cur == 0) {
                        stack.pop();
                    }
                } else {
                    stack.push(cur);
                }
            }
            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}