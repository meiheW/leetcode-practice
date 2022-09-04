/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * Related Topics 数组 回溯 矩阵 👍 673 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-04 16:26:59
 */
public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0) && backTracing(board, i, j, word, 0, used)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backTracing(char[][] board, int i, int j, String word, int index, boolean[][] used) {
            if (index == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length) {
                return false;
            }
            if (j < 0 || j >= board[0].length) {
                return false;
            }

            if (used[i][j] || board[i][j] != word.charAt(index)) {
                return false;
            }
            used[i][j] = true;
            boolean flag = backTracing(board, i + 1, j, word, index + 1, used)
                    || backTracing(board, i - 1, j, word, index + 1, used)
                    || backTracing(board, i, j + 1, word, index + 1, used)
                    || backTracing(board, i, j - 1, word, index + 1, used);
            used[i][j] = false;
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}