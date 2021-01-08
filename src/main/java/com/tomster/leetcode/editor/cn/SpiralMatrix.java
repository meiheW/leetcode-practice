//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 578 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-09 01:15:24
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            //right
            for (int j = colStart; j <= colEnd; j++) {
                result.add(matrix[rowStart][j]);
            }
            rowStart++;
            //down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            //这一步一定要加
            if (rowEnd < rowStart || colEnd < colStart) {
                break;
            }

            //left
            for (int j = colEnd; j >= colStart; j--) {
                result.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            //up
            for (int i = rowEnd; i >= rowStart; i--) {
                result.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}