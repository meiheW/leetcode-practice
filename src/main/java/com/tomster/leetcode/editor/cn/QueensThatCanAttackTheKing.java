//在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。 
//
// 「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。 
//
// 「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。 
//
// 请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
//输出：[[0,1],[1,0],[3,3]]
//解释： 
//[0,1] 的皇后可以攻击到国王，因为他们在同一行上。 
//[1,0] 的皇后可以攻击到国王，因为他们在同一列上。 
//[3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。 
//[0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。 
//[4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。 
//[2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
//输出：[[2,2],[3,4],[4,4]]
// 
//
// 示例 3： 
//
// 
//
// 
//输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3]
//,[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[
//0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
//输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queens.length <= 63 
// queens[i].length == 2 
// 0 <= queens[i][j] < 8 
// king.length == 2 
// 0 <= king[0], king[1] < 8 
// 一个棋盘格上最多只能放置一枚棋子。 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 38 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-10-30 10:33:18
 */
public class QueensThatCanAttackTheKing {
    public static void main(String[] args) {
        Solution solution = new QueensThatCanAttackTheKing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            boolean[][] used = new boolean[8][8];
            for (int[] queen : queens) {
                used[queen[0]][queen[1]] = true;
            }
            List<List<Integer>> ans = new ArrayList<>();
            int[][] directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
            for (int[] direction : directions) {
                int row = king[0] + direction[0];
                int col = king[1] + direction[1];
                while (row >= 0 && row < 8 && col >= 0 && col < 8) {
                    if (used[row][col]) {
                        ans.add(Arrays.asList(row, col));
                        break;
                    } else {
                        row += direction[0];
                        col += direction[1];
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}