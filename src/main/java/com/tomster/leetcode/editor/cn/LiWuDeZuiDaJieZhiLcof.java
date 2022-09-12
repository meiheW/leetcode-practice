/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到
 * 达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 328 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-12 15:11:09
 */
public class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = grid[0][j] + dp[0][j - 1];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}