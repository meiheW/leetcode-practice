//给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。 
//
// 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 
//X 和 Y 坐标，ri 表示爆炸范围的 半径 。 
//
// 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。 
//
// 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：bombs = [[2,1,3],[6,1,4]]
//输出：2
//解释：
//上图展示了 2 个炸弹的位置和爆炸范围。
//如果我们引爆左边的炸弹，右边的炸弹不会被影响。
//但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
//所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：bombs = [[1,1,5],[10,10,5]]
//输出：1
//解释：
//引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
//输出：5
//解释：
//最佳引爆炸弹为炸弹 0 ，因为：
//- 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
//- 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
//- 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
//所以总共有 5 个炸弹被引爆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bombs.length <= 100 
// bombs[i].length == 3 
// 1 <= xi, yi, ri <= 105 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 几何 数组 数学 
// 👍 20 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2022-04-23 20:33:19
 */
public class DetonateTheMaximumBombs {
    public static void main(String[] args) {
        Solution solution = new DetonateTheMaximumBombs().new Solution();
        int i = solution.maximumDetonation(new int[][]{{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumDetonation(int[][] bombs) {
            //bombs[i]能引爆的炸弹下标集合
            Map<Integer, List<Integer>> map = calcMap(bombs);
            int ans = 0;
            boolean[] used = new boolean[bombs.length];
            for (int i = 0; i < bombs.length; i++) {
                ans = Math.max(ans, dfs(i, map, used));
                Arrays.fill(used, false);
            }
            return ans;
        }

        private Map<Integer, List<Integer>> calcMap(int[][] bombs) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < bombs.length; i++) {
                long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
                List<Integer> indexList = new ArrayList<>();
                for (int j = 0; j < bombs.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    long x1 = bombs[j][0], y1 = bombs[j][1];
                    if ((x - x1) * (x - x1) + (y - y1) * (y - y1) <= r * r) {
                        indexList.add(j);
                    }
                }
                map.put(i, indexList);
            }
            return map;
        }

        private int dfs(int index, Map<Integer, List<Integer>> map, boolean[] used) {
            used[index] = true;
            int ans = 1;
            List<Integer> idxes = map.get(index);
            for (Integer idx : idxes) {
                if (used[idx]) {
                    continue;
                }
                ans += dfs(idx, map, used);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}