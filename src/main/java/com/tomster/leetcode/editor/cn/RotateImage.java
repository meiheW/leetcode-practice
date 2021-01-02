//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 745 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-02 20:07:35
 */
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 旋转一个n阶矩阵，相当于转置后镜像
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            //先转置后镜像
            transpose(matrix);
            mirror(matrix);
        }

        private void mirror(int[][] matrix) {
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length/2;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix[0].length-j-1];
                    matrix[i][matrix[0].length-j-1] = temp;
                }
            }
        }

        private void transpose(int[][] matrix) {
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}