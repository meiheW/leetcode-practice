//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 121 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-17 18:10:02
 */
public class NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：grid =
        // [[1,1,1,1,1,1,1,0],
        // [1,0,0,0,0,1,1,0],
        // [1,0,1,0,1,1,1,0],
        // [1,0,0,0,0,1,0,1],
        // [1,1,1,1,1,1,1,0]]
        //输出：2  0：土地，1：水
        public int closedIsland(int[][] grid) {
            int ans = 0;
            int m = grid.length, n = grid[0].length;
            //因为靠边的岛屿也不算，所以先将靠边的土地淹没
            for (int i = 0; i < m; i++) {
                dfs(i, 0, grid);
                dfs(i, n - 1, grid);
            }
            for (int j = 0; j < n; j++) {
                dfs(0, j, grid);
                dfs(m - 1, j, grid);
            }
            //遍历矩阵，dfs确定结果
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        ans++;
                        dfs(i, j, grid);
                    }
                }
            }
            return ans;
        }

        private void dfs(int i, int j, int[][] grid) {
            if (i < 0 || i >= grid.length) {
                return;
            }
            if (j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 1) {
                return;
            }
            grid[i][j] = 1;
            dfs(i + 1, j, grid);
            dfs(i - 1, j, grid);
            dfs(i, j + 1, grid);
            dfs(i, j - 1, grid);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}