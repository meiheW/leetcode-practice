/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数
 * <p>
 * ，判断数组中是否含有该整数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * <p>
 * [
 * [1, 4, 7, 11, 15],
 * [2, 5, 8, 12, 19],
 * [3, 6, 9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * <p>
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * Related Topics 数组 二分查找 分治 矩阵 👍 773 👎 0
 */


package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-02 16:36:19
 */
public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int m = matrix.length, n = matrix[0].length;
            int row = 0, col = n - 1;
            while (row < m && col >= 0) {
                if (matrix[row][col] > target) {
                    col--;
                } else if (matrix[row][col] < target) {
                    row++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}