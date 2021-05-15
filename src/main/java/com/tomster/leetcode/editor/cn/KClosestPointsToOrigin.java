//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法 
// 👍 244 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2021-05-15 13:34:55
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 排序
         */
        public int[][] kClosest(int[][] points, int k) {
            Arrays.sort(points, Comparator.comparingInt(o -> squareSum(o[0], o[1])));
            return Arrays.copyOfRange(points, 0, k);
        }

        /**
         * 堆
         */
        public int[][] kClosestHeap(int[][] points, int k) {
            if (points == null) {
                return null;
            }
            //K个最小->最大堆 存放坐标点的index
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (o1, o2) -> squareSum(points[o2][0], points[o2][1]) - squareSum(points[o1][0], points[o1][1]));
            for (int i = 0; i < points.length; i++) {
                if (pq.size() < k) {
                    pq.add(i);
                } else {
                    Integer peek = pq.peek();
                    if (squareSum(points[peek][0], points[peek][1]) > squareSum(points[i][0], points[i][1])) {
                        pq.add(i);
                        pq.poll();
                    }
                }
            }

            int[][] result = new int[pq.size()][2];
            for (int i = 0; i < result.length; i++) {
                Integer peek = pq.poll();
                result[i][0] = points[peek][0];
                result[i][1] = points[peek][1];
            }
            return result;
        }

        public int squareSum(int x, int y) {
            return (int) (Math.pow(x, 2) + Math.pow(y, 2));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}