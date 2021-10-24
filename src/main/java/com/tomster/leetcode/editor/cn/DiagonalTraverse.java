//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// -105 <= mat[i][j] <= 105 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 237 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-10-24 12:31:55
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    List<Integer> list = map.get(i + j);
                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(mat[i][j]);
                        map.put(i + j, list);
                    } else {
                        list.add(mat[i][j]);
                    }
                }
            }

            int[] result = new int[m * n];
            int index = 0;
            for (int i = 0; i <= m + n - 2; i++) {
                List<Integer> list = map.get(i);
                if (i % 2 == 0) {
                    Collections.reverse(list);
                }
                for (Integer item : list) {
                    result[index++] = item;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}