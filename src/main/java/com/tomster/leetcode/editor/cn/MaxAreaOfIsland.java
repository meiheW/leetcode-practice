//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 723 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-17 18:36:08
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int ans = 0;

        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int area = dfs(grid, i, j);
                        ans = Math.max(ans, area);
                    }
                }
            }
            return ans;
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length) {
                return 0;
            }
            if (j < 0 || j >= grid[0].length) {
                return 0;
            }
            if (grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;//陆地变海水
            int area = 1;
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            for (int[] direction : directions) {
                //加上周围能连接的陆地
                area += dfs(grid, i + direction[0], j + direction[1]);
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}