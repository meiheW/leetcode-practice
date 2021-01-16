//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 224 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-17 00:59:28
 */
public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int result = 0;

        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }

            backTrace(board, 0, n);
            return result;
        }

        private void backTrace(char[][] board, int row, int n) {
            if (row == n) {
                result++;
                return;
            }
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col, n)) {
                    continue;
                }
                board[row][col] = 'Q';
                backTrace(board, row + 1, n);
                board[row][col] = '.';
            }

        }

        private boolean isValid(char[][] board, int row, int col, int n) {
            //列
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            //右上方
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            //左上方
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}