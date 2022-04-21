//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
// Related Topics 数组 二分查找 矩阵 
// 👍 88 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-04-02 16:39:12
 */
public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new CountNegativeNumbersInASortedMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //矩阵行列皆非递增，负数的个数
        //输入：grid =
        // [ [4,3,2,-1],
        //   [3,2,1,-1],
        //   [1,1,-1,-2],
        //   [-1,-1,-2,-3] ]
        //输出：8
        public int countNegatives(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int r = 0, c = n - 1;
            int ans = 0;
            while (r < m && c >= 0) {
                if (grid[r][c] >= 0) {
                    r++;
                } else {
                    ans += (m - r);
                    c--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}