//给你一个大小为 m x n 的整数矩阵 grid ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。 
//
// 矩阵由若干层组成，如下图所示，每种颜色代表一层： 
//
// 
//
// 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
// 
//
// 返回执行 k 次循环轮转操作后的矩阵。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[40,10],[30,20]], k = 1
//输出：[[10,20],[40,30]]
//解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。 
//
// 示例 2： 
// 
//
// 输入：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
//输出：[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
//解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 50 
// m 和 n 都是 偶数 
// 1 <= grid[i][j] <= 5000 
// 1 <= k <= 109 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 10 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-10-30 11:50:05
 */
public class CyclicallyRotatingAGrid {
    public static void main(String[] args) {
        Solution solution = new CyclicallyRotatingAGrid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int mL = 0, mH = m - 1, nL = 0, nH = n - 1;
            while (mH >= mL && nH >= nL) {
                List<Integer> circle = new ArrayList<>();
                for (int i = mL; i < mH; i++) {
                    circle.add(grid[i][nL]);
                }
                for (int j = nL; j < nH; j++) {
                    circle.add(grid[mH][j]);
                }
                for (int i = mH; i > mL; i--) {
                    circle.add(grid[i][nH]);
                }
                for (int j = nH; j > nL; j--) {
                    circle.add(grid[mL][j]);
                }
                int move = k % circle.size();
                while (move-- > 0) {
                    circle.add(0, circle.remove(circle.size() - 1));
                }
                int index = 0;
                for (int i = mL; i < mH; i++) {
                    grid[i][nL] = circle.get(index++);
                }
                for (int j = nL; j < nH; j++) {
                    grid[mH][j] = circle.get(index++);
                }
                for (int i = mH; i > mL; i--) {
                    grid[i][nH] = circle.get(index++);
                }
                for (int j = nH; j > nL; j--) {
                    grid[mL][j] = circle.get(index++);
                }

                mL++;
                mH--;
                nL++;
                nH--;
            }
            return grid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}