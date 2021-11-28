//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
// Related Topics 贪心 数组 动态规划 排序 
// 👍 196 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: tomster
 * @data: 2021-11-28 12:11:42
 */
public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfPairChain().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //贪心算法，右端点升序排列
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
            int ans = 0;
            int cur = Integer.MIN_VALUE;
            for (int[] pair : pairs) {
                if (pair[0] > cur) {
                    ans++;
                    cur = pair[1];
                }
            }
            return ans;
        }

        //动态规划，这种题目看下来就是动态规划
        //我写的和官网题解一样，不过时间复杂度O(N^2)
        public int findLongestChain1(int[][] pairs) {
            Arrays.sort(pairs, (o1, o2) -> o1[0] != o2[0]
                    ? Integer.compare(o1[0], o2[0])
                    : Integer.compare(o1[1], o2[1]));
            int n = pairs.length;
            int ans = 1;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    //pairs[j].end < pairs[i].start
                    if (pairs[j][1] < pairs[i][0]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + 1;
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}