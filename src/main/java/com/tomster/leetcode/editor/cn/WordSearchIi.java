//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 
// 👍 635 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2022-03-28 14:00:27
 */
public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
        //      words = ["oath","pea","eat","rain"]
        //输出：["eat","oath"]
        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            Set<String> ans = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    backTracing(ans, board, i, j, trie);
                }
            }
            return new ArrayList<>(ans);
        }

        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        private void backTracing(Set<String> ans, char[][] board, int i, int j, Trie trie) {
            if (i < 0 || i >= board.length) {
                return;
            }
            if (j < 0 || j >= board[0].length) {
                return;
            }
            char c = board[i][j];
            if (!trie.children.containsKey(c)) {
                return;
            }
            Trie child = trie.children.get(c);
            if (!"".equals(child.word)) {
                ans.add(child.word);
            }
            board[i][j] = '#';
            for (int[] direction : directions) {
                backTracing(ans, board, i + direction[0], j + direction[1], child);
            }
            board[i][j] = c;
        }


        /**
         * 字典树
         */
        class Trie {

            Map<Character, Trie> children;

            String word;

            Trie() {
                children = new HashMap<>();
                word = "";
            }

            public void insert(String word) {
                Trie trie = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!trie.children.containsKey(c)) {
                        trie.children.put(c, new Trie());
                    }
                    trie = trie.children.get(c);
                }
                trie.word = word;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}