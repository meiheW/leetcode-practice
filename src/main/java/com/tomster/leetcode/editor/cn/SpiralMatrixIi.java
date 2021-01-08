//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 280 👎 0

package com.tomster.leetcode.editor.cn;
/**
 * @author: tomster
 * @data: 2021-01-09 01:15:22
 */
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return null;
        }
        int[][] matrix = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = n - 1;
        int num = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //rowBegin right
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = ++num;
            }
            rowBegin++;
            //colEnd down
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = ++num;
            }
            colEnd--;

            //判断是否继续
            if (rowBegin > rowEnd && colBegin > colEnd) {
                break;
            }
            //rowEnd up
            for (int j = colEnd; j >= colBegin; j--) {
                matrix[rowEnd][j] = ++num;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = ++num;
            }
            colBegin++;

        }

        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}