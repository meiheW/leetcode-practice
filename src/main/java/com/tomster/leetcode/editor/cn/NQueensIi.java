//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 224 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-01-17 00:59:28
 */
public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        int i = solution.totalNQueens(4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Set<Integer> occupiedCols = new HashSet<>();
        private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
        private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();

        public int totalNQueens(int n) {
            return totalNQueensHelper(0, 0, n);
        }

        private int totalNQueensHelper(int row, int count, int n) {
            for (int col = 0; col < n; col++) {
                if (occupiedCols.contains(col))
                    continue;
                int diag1 = row - col;
                if (occupiedDiag1s.contains(diag1))
                    continue;
                int diag2 = row + col;
                if (occupiedDiag2s.contains(diag2))
                    continue;
                if (row == n - 1)
                    count++;
                else {
                    occupiedCols.add(col);
                    occupiedDiag1s.add(diag1);
                    occupiedDiag2s.add(diag2);
                    count = totalNQueensHelper(row + 1, count, n);
                    occupiedCols.remove(col);
                    occupiedDiag1s.remove(diag1);
                    occupiedDiag2s.remove(diag2);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}