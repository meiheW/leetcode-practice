//给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为： 
//
// 
// '#' 表示石头 
// '*' 表示固定的障碍物 
// '.' 表示空位置 
// 
//
// 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影
//响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。 
//
// 题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。 
//
// 请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：box = [["#",".","#"]]
//输出：[["."],
//      ["#"],
//      ["#"]]
// 
//
// 示例 2： 
//
// 
//
// 输入：box = [["#",".","*","."],
//            ["#","#","*","."]]
//输出：[["#","."],
//      ["#","#"],
//      ["*","*"],
//      [".","."]]
// 
//
// 示例 3： 
//
// 
//
// 输入：box = [["#","#","*",".","*","."],
//            ["#","#","#","*",".","."],
//            ["#","#","#",".","#","."]]
//输出：[[".","#","#"],
//      [".","#","#"],
//      ["#","#","*"],
//      ["#","*","."],
//      ["#",".","*"],
//      ["#",".","."]]
// 
//
// 
//
// 提示： 
//
// 
// m == box.length 
// n == box[i].length 
// 1 <= m, n <= 500 
// box[i][j] 只可能是 '#' ，'*' 或者 '.' 。 
// 
// Related Topics 数组 双指针 矩阵 
// 👍 7 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-26 20:21:52
 */
public class RotatingTheBox {
    public static void main(String[] args) {
        Solution solution = new RotatingTheBox().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            int m = box.length, n = box[0].length;
            for (int i = 0; i < m; i++) {
                int stoneCount = 0;
                for (int j = 0; j <= n; j++) {
                    char c = j == n ? '*' : box[i][j];
                    if (c == '#') {
                        stoneCount++;
                    } else if (c == '*') {
                        if (stoneCount > 0) {
                            int k = j - 1;
                            while (k >= 0 && stoneCount > 0) {
                                box[i][k--] = '#';
                                stoneCount--;
                            }
                            while (k >= 0 && box[i][k] != '*') {
                                box[i][k--] = '.';
                            }
                        }
                    }

                }
            }
            return rotate(box);
        }

        //顺时针旋转90°
        private char[][] rotate(char[][] box) {
            int m = box.length, n = box[0].length;
            char[][] rotate = new char[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotate[j][m - 1 - i] = box[i][j];
                }
            }
            return rotate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}