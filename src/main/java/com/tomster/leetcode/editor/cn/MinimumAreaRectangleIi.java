//给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。 
//
// 如果没有任何矩形，就返回 0。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[1,2],[2,1],[1,0],[0,1]]
//输出：2.00000
//解释：最小面积的矩形出现在 [1,2],[2,1],[1,0],[0,1] 处，面积为 2。 
//
// 示例 2： 
//
// 
//
// 输入：[[0,1],[2,1],[1,1],[1,0],[2,0]]
//输出：1.00000
//解释：最小面积的矩形出现在 [1,0],[1,1],[2,1],[2,0] 处，面积为 1。
// 
//
// 示例 3： 
//
// 
//
// 输入：[[0,3],[1,2],[3,1],[1,3],[2,1]]
//输出：0
//解释：没法从这些点中组成任何矩形。
// 
//
// 示例 4： 
//
// 
//
// 输入：[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
//输出：2.00000
//解释：最小面积的矩形出现在 [2,1],[2,3],[3,3],[3,1] 处，面积为 2。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 50 
// 0 <= points[i][0] <= 40000 
// 0 <= points[i][1] <= 40000 
// 所有的点都是不同的。 
// 与真实值误差不超过 10^-5 的答案将视为正确结果。 
// 
// Related Topics 几何 数组 数学 
// 👍 49 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-11-27 21:43:29
 */
public class MinimumAreaRectangleIi {
    public static void main(String[] args) {
        Solution solution = new MinimumAreaRectangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Point {
            int x;
            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point p = (Point) obj;
                return p.x == this.x && p.y == this.y;
            }

            public boolean equals(Point p) {
                return p.x == this.x && p.y == this.y;
            }


            @Override
            public int hashCode() {
                return (x + "," + y).hashCode();
            }


        }

        //这一题参考的题解，数学知识想到之后还是很好做的
        public double minAreaFreeRect(int[][] points) {
            Set<Point> set = new HashSet<>();
            Point[] arr = new Point[points.length];
            //for (int[] point : points) {
            for (int i = 0; i < points.length; i++) {
                Point p = new Point(points[i][0], points[i][1]);
                set.add(p);
                arr[i] = p;
            }
            double minArea = Double.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                Point p1 = arr[i];
                for (int j = 0; j < points.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    Point p2 = arr[j];
                    for (int k = j + 1; k < points.length; k++) {
                        if (k == i) {
                            continue;
                        }
                        Point p3 = arr[k];
                        //向量计算p4的位置，构成以p2p3为对角线的平行四边形
                        //OP4 = OP2 + OP3 - OP1
                        Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
                        if (set.contains(p4)) {
                            //判断角P2P1P3是否直角
                            // 点积 (p2.x-p1.x, p2.y-p1.y) (p3.x-p1.x, p3.y-p1.y)是否为0
                            if ((p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y) == 0) {
                                //double area = p1.distance(p2) * p1.distance(p3);
                                //叉积 (p2.x-p1.x, p2.y-p1.y) (p3.x-p1.x, p3.y-p1.y)
                                double area = Math.abs((p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y));
                                if (area < minArea) {
                                    minArea = area;
                                }
                            }
                        }
                    }
                }
            }
            return minArea == Double.MAX_VALUE ? 0 : minArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}