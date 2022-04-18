//
//
// 如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。 
//
// 给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，researvedSeats[i]=[3,8] ，它表示第 3 行第 8 个座
//位被预约了。 
//
// 请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座
//位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
//输出：4
//解释：上图所示是最优的安排方案，总共可以安排 4 个家庭。蓝色的叉表示被预约的座位，橙色的连续座位表示一个 4 人家庭。
// 
//
// 示例 2： 
//
// 输入：n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
//输出：2
// 
//
// 示例 3： 
//
// 输入：n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^9 
// 1 <= reservedSeats.length <= min(10*n, 10^4) 
// reservedSeats[i].length == 2 
// 1 <= reservedSeats[i][0] <= n 
// 1 <= reservedSeats[i][1] <= 10 
// 所有 reservedSeats[i] 都是互不相同的。 
// 
// Related Topics 贪心 位运算 数组 哈希表 
// 👍 49 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2022-04-18 16:03:13
 */
public class CinemaSeatAllocation {
    public static void main(String[] args) {
        Solution solution = new CinemaSeatAllocation().new Solution();
        int i = solution.maxNumberOfFamilies(2, new int[][]{{2, 1}, {1, 8}, {2, 6}});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            int left = 0b11110000;
            int right = 0b00001111;
            int middle = 0b11000011;
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] rs : reservedSeats) {
                if (rs[1] >= 2 && rs[1] <= 9) {
                    int origin = map.containsKey(rs[0]) ? map.get(rs[0]) : 0;
                    int value = origin | (1 << (rs[1] - 2));
                    map.put(rs[0], value);
                }
            }

            int ans = (n - map.keySet().size()) * 2;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int bitMask = entry.getValue();
                if (((bitMask | left) == left) || ((bitMask | middle) == middle) || ((bitMask | right) == right)) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}