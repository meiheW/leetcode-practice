//给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。 
//
// 如果没有任何矩形，就返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 500 
// 0 <= points[i][0] <= 40000 
// 0 <= points[i][1] <= 40000 
// 所有的点都是不同的。 
// 
// Related Topics 几何 数组 哈希表 数学 排序 
// 👍 92 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-09-14 19:54:09
 */
public class MinimumAreaRectangle {
    public static void main(String[] args) {
        Solution solution = new MinimumAreaRectangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAreaRect(int[][] points) {
            //把所有点存到横坐标及其所有对应的纵坐标的TreeMap中
            Map<Integer, List<Integer>> rows = new TreeMap<>();
            for (int i = 0; i < points.length; i++) {
                int x = points[i][0];
                int y = points[i][1];
                rows.computeIfAbsent(x, z -> new ArrayList<>()).add(y);
            }
            Map<Integer, Integer> lastX = new HashMap<>();
            int ans = Integer.MAX_VALUE;
            //遍历每个横坐标
            for (Integer x : rows.keySet()) {
                List<Integer> rowList = rows.get(x);
                Collections.sort(rowList);
                int n = rowList.size();
                //遍历每个横坐标中的所有点对
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int y1 = rowList.get(i);
                        int y2 = rowList.get(j);
                        int key = y1 * 40001 + y2;
                        //同样出现y1,y2的上一个x，就更新结果
                        if (lastX.containsKey(key)) {
                            ans = Math.min(ans, (x - lastX.get(key)) * (y2 - y1));
                        }
                        //保存y点对和最近的x
                        lastX.put(key, x);
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}