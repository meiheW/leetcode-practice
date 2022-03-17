//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 160 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-17 18:32:11
 */
public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            //将能够移动到边界的土地淹没
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j);
                dfs(grid, m - 1, j);
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length) {
                return;
            }
            if (j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 0) {
                return;
            }
            grid[i][j] = 0;
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}