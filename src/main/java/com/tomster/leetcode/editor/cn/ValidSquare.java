//给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。 
//
// 一个点的坐标（x，y）由一个有两个整数的整数数组表示。 
//
// 示例: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 
//
// 注意: 
//
// 
// 所有输入整数都在 [-10000，10000] 范围内。 
// 一个有效的正方形有四个等长的正长和四个等角（90度角）。 
// 输入点没有顺序。 
// 
// Related Topics 几何 数学 
// 👍 78 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-14 15:51:23
 */
public class ValidSquare {
    public static void main(String[] args) {
        Solution solution = new ValidSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            int[][] p = new int[][]{p1, p2, p3, p4};
            //x坐标升序,y坐标升序
            Arrays.sort(p, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
            //四条边相等，对角线相等
            return distance(p[0], p[1]) != 0
                    && distance(p[0], p[1]) == distance(p[1], p[3])
                    && distance(p[1], p[3]) == distance(p[3], p[2])
                    && distance(p[3], p[2]) == distance(p[2], p[0])
                    && distance(p[0], p[3]) == distance(p[1], p[2]);
        }

        private long distance(int[] p1, int[] p2) {
            return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}