//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1085 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-25 11:43:02
 */
public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            //dp[i][j]：matrix[i][j]为右下角的最大正方形长度
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = matrix[0][j] == '0' ? 0 : 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }
            int len = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    len = Math.max(len, dp[i][j]);
                }
            }
            return len * len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}