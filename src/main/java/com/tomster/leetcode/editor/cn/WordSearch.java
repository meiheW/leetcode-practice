//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 744 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-17 20:44:42
 */
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (backTrace(word, board, used, i, j, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean backTrace(String word, char[][] board, boolean[][] used, int i, int j, int index) {
            //终止条件
            if (index == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return false;
            }
            if (used[i][j]) {
                return false;
            }
            used[i][j] = true;
            boolean matched = word.charAt(index) == board[i][j] &&
                    (backTrace(word, board, used, i - 1, j, index + 1)
                            || backTrace(word, board, used, i + 1, j, index + 1)
                            || backTrace(word, board, used, i, j - 1, index + 1)
                            || backTrace(word, board, used, i, j + 1, index + 1));
            used[i][j] = false;
            return matched;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}