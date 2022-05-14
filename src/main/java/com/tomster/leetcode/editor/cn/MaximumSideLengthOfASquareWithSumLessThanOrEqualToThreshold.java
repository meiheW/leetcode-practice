//给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。 
//
// 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
//输出：2
//解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], thresh
//old = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 300 
// 0 <= mat[i][j] <= 104 
// 0 <= threshold <= 105 
// 
// Related Topics 数组 二分查找 矩阵 前缀和 
// 👍 92 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-05-14 15:32:07
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    public static void main(String[] args) {
        Solution solution = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            //二分查找
            int row = mat.length, col = mat[0].length;
            int[][] prefix = new int[row + 1][col + 1];
            for (int i = 1; i <= row; ++i) {
                for (int j = 1; j <= col; ++j) {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }

            int left = 0, right = Math.min(row, col), mid = 0, res = 0;
            while (left < right) {
                mid = left + right + 1 >> 1;
                boolean flag = false;
                for (int i = 1; i + mid <= row + 1; ++i) {
                    for (int j = 1; j + mid <= col + 1; ++j) {
                        int temp = prefix[i + mid - 1][j + mid - 1] - prefix[i + mid - 1][j - 1] - prefix[i - 1][j + mid - 1] + prefix[i - 1][j - 1];
                        if (temp <= threshold) {
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}