//回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。 
//
// 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,1],[2,3],[3,2]]
//输出：true
// 
//
// 示例 2： 
//
// 输入：[[1,1],[2,2],[3,3]]
//输出：false 
//
// 
//
// 提示： 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= points[i][j] <= 100 
// 
// Related Topics 几何 数学 
// 👍 29 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-14 16:09:02
 */
public class ValidBoomerang {
    public static void main(String[] args) {
        Solution solution = new ValidBoomerang().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBoomerang(int[][] points) {
            int x1 = points[0][0], y1 = points[0][1];
            int x2 = points[1][0], y2 = points[1][1];
            int x3 = points[2][0], y3 = points[2][1];
            //斜率不一样即可
            return ((y2 - y1) * (x3 - x1)) != ((y3 - y1) * (x2 - x1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}