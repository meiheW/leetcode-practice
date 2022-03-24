//给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 ma
//t[r][c] 的和： 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k 且 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 数组 矩阵 前缀和 
// 👍 131 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-23 21:40:47
 */
public class MatrixBlockSum {
    public static void main(String[] args) {
        Solution solution = new MatrixBlockSum().new Solution();
        solution.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            int[][] preMat = getPreMatrix(mat, m, n);
            return getAns(preMat, m, n, k);
        }

        private int[][] getAns(int[][] preMat, int m, int n, int k) {
            int[][] ans = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int x1 = Math.max(0, i - k), y1 = Math.max(0, j - k);
                    int x2 = Math.min(m, i + k + 1), y2 = Math.min(n, j + k + 1);
                    ans[i][j] = preMat[x2][y2] - preMat[x2][y1] - preMat[x1][y2] + preMat[x1][y1];
                }
            }
            return ans;
        }

        private int[][] getPreMatrix(int[][] mat, int m, int n) {
            int[][] preMat = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    preMat[i + 1][j + 1] = preMat[i][j + 1] + preMat[i + 1][j] - preMat[i][j] + mat[i][j];
                }
            }
            return preMat;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}