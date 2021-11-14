//给你一个以 (radius, x_center, y_center) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2)，其中 (x1, y
//1) 是矩形左下角的坐标，(x2, y2) 是右上角的坐标。 
//
// 如果圆和矩形有重叠的部分，请你返回 True ，否则返回 False 。 
//
// 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
//输出：true
//解释：圆和矩形有公共点 (1,0) 
// 
//
// 示例 2： 
//
// 
//
// 输入：radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 输入：radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3
//输出：true
// 
//
// 示例 4： 
//
// 输入：radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= radius <= 2000 
// -10^4 <= x_center, y_center, x1, y1, x2, y2 <= 10^4 
// x1 < x2 
// y1 < y2 
// 
// Related Topics 几何 数学 
// 👍 30 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-14 21:57:40
 */
public class CircleAndRectangleOverlapping {
    public static void main(String[] args) {
        Solution solution = new CircleAndRectangleOverlapping().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
            if (x_center >= x1 && x_center <= x2 && y_center >= y1 - radius && y_center <= y2 + radius) {
                return true;
            }
            if (x_center >= x1 - radius && x_center <= x2 + radius && y_center >= y1 && y_center <= y2) {
                return true;
            }
            int[][] corner = new int[][]{{x1, y1}, {x2, y1}, {x1, y2}, {x2, y2}};
            for (int i = 0; i < 4; i++) {
                if (Math.pow(corner[i][0] - x_center, 2) + Math.pow(corner[i][1] - y_center, 2) <= radius * radius) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}