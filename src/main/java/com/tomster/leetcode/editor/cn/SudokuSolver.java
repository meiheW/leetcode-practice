//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 732 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-17 15:06:38
 */
public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            backTrace(board, 0, 0);
        }

        private boolean backTrace(char[][] board, int row, int col) {
            int n = 9;
            if (col == n) {
                return backTrace(board, row + 1, 0);
            }
            //终止条件
            if (row == n) {
                return true;
            }

            for (int i = row; i < n; i++) {
                for (int j = col; j < n; j++) {
                    if (board[i][j] != '.') {
                        return backTrace(board, i, j + 1);
                    }
                    for (char c = '1'; c <= '9'; c++) {
                        if (!isValid(board, i, j, c)) {
                            continue;
                        }
                        board[i][j] = c;
                        if (backTrace(board, i, j + 1)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
            return false;
        }


        // 判断 board[i][j] 是否可以填入 n
        boolean isValid(char[][] board, int r, int c, char n) {
            for (int i = 0; i < 9; i++) {
                // 判断行是否存在重复
                if (board[r][i] == n) return false;
                // 判断列是否存在重复
                if (board[i][c] == n) return false;
                // 判断 3 x 3 方框是否存在重复
                if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n)
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}