//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1603 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-17 17:53:44
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：grid = [
        //  ["1","1","1","1","0"],
        //  ["1","1","0","1","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","0","0","0"]
        //]
        //输出：1
        public int numIslands1(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        dfs(i, j, grid);
                    }
                }
            }
            return ans;
        }

        private void dfs(int i, int j, char[][] grid) {
            if (i < 0 || i >= grid.length) {
                return;
            }
            if (j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j - 1, grid);
            dfs(i, j + 1, grid);
        }


        //下面这个做法不改变原矩阵
        public int numIslands(char[][] grid) {
            int ans = 0;
            int m = grid.length, n = grid[0].length;
            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1' && !used[i][j]) {
                        ans++;
                        dfs1(i, j, grid, used);
                    }
                }
            }
            return ans;
        }

        private void dfs1(int i, int j, char[][] grid, boolean[][] used) {
            if (i < 0 || i >= grid.length) {
                return;
            }
            if (j < 0 || j >= grid[0].length) {
                return;
            }
            if (used[i][j] || grid[i][j] == '0') {
                return;
            }
            used[i][j] = true;
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            for (int[] direction : directions) {
                dfs1(i + direction[0], j + direction[1], grid, used);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}