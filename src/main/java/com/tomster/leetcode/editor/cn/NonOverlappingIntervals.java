//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 105 
// intervals[i].length == 2 
// -5 * 104 <= starti < endi <= 5 * 104 
// 
// Related Topics 贪心 数组 动态规划 排序 
// 👍 630 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: tomster
 * @data: 2022-03-17 18:44:58
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
        //输出: 1
        //解释: 移除 [1,3] 后，剩下的区间没有重叠
        //动态规划超时...
        public int eraseOverlapIntervals1(int[][] intervals) {
            int n = intervals.length;
            //区间起点升序排列
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            //dp[i]表示以intervals[i]为最后一个区间集合的最大数量
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (intervals[i][0] >= intervals[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return n - Arrays.stream(dp).max().getAsInt();
        }

        //贪心算法
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            int n = intervals.length;
            int right = intervals[0][1];
            int ans = 1;
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= right) {
                    ans++;
                    right = intervals[i][1];
                }
            }
            return n - ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}