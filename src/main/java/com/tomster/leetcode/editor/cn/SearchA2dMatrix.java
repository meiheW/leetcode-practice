//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics 数组 二分查找
// 👍 298 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-01-15 23:02:24
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //int[][] matrix = new int[][]{{1,3}};
        solution.searchMatrix(matrix, 17);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m - 1;
            while (low <= high) {
                int middle = low + (high - low) / 2;
                int cur = matrix[middle][0];
                if (cur > target) {
                    high = middle - 1;
                } else if (cur < target) {
                    low = middle + 1;
                } else {
                    return true;
                }
            }
            if (high == -1) {
                return false;
            }
            int[] row = matrix[high];
            int i = Arrays.binarySearch(row, target);
            return i >= 0;
        }

        public boolean searchMatrix1(int[][] matrix, int target) {
            if (matrix == null) {
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
                return false;
            }
            int rowLow = 0, rowHigh = m - 1;
            while (rowLow <= rowHigh) {
                int middle = (rowLow + rowHigh) / 2;
                if (matrix[middle][n - 1] < target) {
                    rowLow = middle + 1;
                } else if (matrix[middle][n - 1] > target) {
                    rowHigh = middle - 1;
                } else {
                    return true;
                }
            }

            //如果没有找到，则在rowLow这一行
            int colLow = 0;
            int colHigh = matrix[0].length - 1;
            while (colLow <= colHigh) {
                int middle = (colLow + colHigh) / 2;
                if (matrix[rowLow][middle] == target) {
                    return true;
                } else if (matrix[rowLow][middle] < target) {
                    colLow = middle + 1;
                } else {
                    colHigh = middle - 1;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}