/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * <p>
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * Related Topics 数组 矩阵 模拟 👍 455 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-09-09 14:57:41
 */
public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return new int[]{};
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
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}