//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组 
// 👍 353 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-13 22:58:54
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {

            int row = matrix.length;
            int col = matrix[0].length;
            boolean firstRowZero = false;
            boolean firstColZero = false;
            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    firstRowZero = true;
                    break;
                }
            }
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    firstColZero = true;
                    break;
                }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < row; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < col; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 0; i < row; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firstRowZero) {
                for (int j = 0; j < col; j++) {
                    matrix[0][j] = 0;
                }
            }

            if (firstColZero) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}