//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// 👍 723 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-16 23:55:05
 */
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }

            backTrace(result, board, 0, n);
            return result;
        }

        private void backTrace(List<List<String>> result, char[][] board, int row, int n) {
            if (row == n) {
                result.add(charMatrix2StringList(board));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col, n)) {
                    continue;
                }
                board[row][col] = 'Q';
                backTrace(result, board, row + 1, n);
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

        private List<String> charMatrix2StringList(char[][] board) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(String.valueOf(board[i]));
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}