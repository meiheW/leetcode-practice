//3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。 
//
// 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。 
//
// 
//
// 示例： 
//
// 输入: [[4,3,8,4],
//      [9,5,1,9],
//      [2,7,6,2]]
//输出: 1
//解释: 
//下面的子矩阵是一个 3 x 3 的幻方：
//438
//951
//276
//
//而这一个不是：
//384
//519
//762
//
//总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
// 
//
// 提示: 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// 0 <= grid[i][j] <= 15 
// 
// Related Topics 数组 数学 矩阵 
// 👍 53 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-12-19 16:07:47
 */
public class MagicSquaresInGrid {
    public static void main(String[] args) {
        Solution solution = new MagicSquaresInGrid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    if (idMagic(grid, i, j)) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private boolean idMagic(int[][] grid, int i, int j) {
            //对角线
            if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) {
                return false;
            }
            if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) {
                return false;
            }
            //列
            for (int q = j; q < j + 3; q++) {
                int sum = 0;
                for (int p = i; p < i + 3; p++) {
                    sum += grid[p][q];
                }
                if (sum != 15) {
                    return false;
                }
            }
            //行 以及 1-9的范围
            int[] arr = new int[9];
            int index = 0;
            for (int p = i; p < i + 3; p++) {
                int sum = 0;
                for (int q = j; q < j + 3; q++) {
                    arr[index++] = grid[p][q];
                    sum += grid[p][q];
                }
                if (sum != 15) {
                    return false;
                }
            }
            Arrays.sort(arr);
            for (int k = 0; k < 9; k++) {
                if (arr[k] != k + 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}