//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 
// 👍 139 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-08-22 19:20:38
 */
public class NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new NumberOfBoomerangs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：points = [[0,0],[1,0],[2,0]]
        //输出：2
        //解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
        public int numberOfBoomerangs(int[][] points) {
            int n = points.length;
            int result = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];
                    int distance = dx * dx + dy * dy;
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
                for (Integer value : map.values()) {
                    result += value * (value - 1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}