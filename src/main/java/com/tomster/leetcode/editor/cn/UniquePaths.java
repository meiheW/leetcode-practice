//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 849 👎 0

package com.tomster.leetcode.editor.cn;
/**
 * @author: tomster
 * @data: 2021-01-09 01:24:41
 */
public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        /**
         * 第二思路动态规划
         *
         * @param m
         * @param n
         * @return
         */
        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1) {
                return 1;
            }

            int[][] dp = new int[m][n];
            //初始化首行首列
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    //从左边或者右边移动过来
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[m - 1][n - 1];

        }

        /**
         * 第一思路是用回溯，但是算法超时
         *
         * @param m
         * @param n
         * @return
         */
        public int uniquePaths1(int m, int n) {
            return backTrace(m, n, 1, 1);
        }

        private int backTrace(int m, int n, int x, int y) {
            if (x == m && y == n) {
                return 1;
            } else if (x > m || y > n) {
                return 0;
            } else {
                return backTrace(m, n, x, y + 1) + backTrace(m, n, x + 1, y);
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}