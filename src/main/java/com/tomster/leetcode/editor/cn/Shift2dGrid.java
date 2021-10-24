//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。 
//
// 每次「迁移」操作将会引发下述活动： 
//
// 
// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。 
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。 
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。 
// 
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[9,1,2],[3,4,5],[6,7,8]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//输出：[[1,2,3],[4,5,6],[7,8,9]]
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 50 
// 1 <= n <= 50 
// -1000 <= grid[i][j] <= 1000 
// 0 <= k <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 46 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-10-24 21:21:40
 */
public class Shift2dGrid {
    public static void main(String[] args) {
        Solution solution = new Shift2dGrid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int[] temp = new int[m];
            while (k-- > 0) {
                for (int i = 0; i < m; i++) {
                    temp[i] = grid[i][n - 1];
                }
                for (int j = n - 1; j > 0; j--) {
                    for (int i = 0; i < m; i++) {
                        grid[i][j] = grid[i][j - 1];
                    }
                }
                grid[0][0] = temp[m - 1];
                for (int i = 0; i < m - 1; i++) {
                    grid[i + 1][0] = temp[i];
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int[] row : grid) {
                List<Integer> rowList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    rowList.add(row[j]);
                }
                ans.add(rowList);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}