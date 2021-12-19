//你正在玩一个单人游戏，面前放置着大小分别为 a、b 和 c 的 三堆 石子。 
//
// 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。 
//
// 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。 
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = 4, c = 6
//输出：6
//解释：石子起始状态是 (2, 4, 6) ，最优的一组操作是：
//- 从第一和第三堆取，石子状态现在是 (1, 4, 5)
//- 从第一和第三堆取，石子状态现在是 (0, 4, 4)
//- 从第二和第三堆取，石子状态现在是 (0, 3, 3)
//- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
//- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
//- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
//总分：6 分 。
// 
//
// 示例 2： 
//
// 
//输入：a = 4, b = 4, c = 6
//输出：7
//解释：石子起始状态是 (4, 4, 6) ，最优的一组操作是：
//- 从第一和第二堆取，石子状态现在是 (3, 3, 6)
//- 从第一和第三堆取，石子状态现在是 (2, 3, 5)
//- 从第一和第三堆取，石子状态现在是 (1, 3, 4)
//- 从第一和第三堆取，石子状态现在是 (0, 3, 3)
//- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
//- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
//- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
//总分：7 分 。
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = 8, c = 8
//输出：8
//解释：最优的一组操作是连续从第二和第三堆取 8 回合，直到将它们取空。
//注意，由于第二和第三堆已经空了，游戏结束，不能继续从第一堆中取石子。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b, c <= 105 
// 
// Related Topics 贪心 数学 堆（优先队列） 
// 👍 24 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2021-12-19 17:55:15
 */
public class MaximumScoreFromRemovingStones {
    public static void main(String[] args) {
        Solution solution = new MaximumScoreFromRemovingStones().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumScore(int a, int b, int c) {
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            int mid = a + b + c - max - min;
            if (max >= min + mid) {
                return min + mid;
            } else {
                return (a + b + c) / 2;
            }
        }

        //优先队列
        public int maximumScore1(int a, int b, int c) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            pq.addAll(Arrays.asList(a, b, c));
            int count = 0;
            while (pq.size() > 1) {
                count++;
                Integer peek1 = pq.poll();
                Integer peek2 = pq.poll();
                if (peek1 > 1) {
                    pq.add(peek1 - 1);
                }
                if (peek2 > 1) {
                    pq.add(peek2 - 1);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}