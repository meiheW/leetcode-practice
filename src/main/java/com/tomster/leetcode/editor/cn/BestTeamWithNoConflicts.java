//假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。 
//
// 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间
//不会发生矛盾。 
//
// 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队
//中得分最高那支的分数 。 
//
// 
//
// 示例 1： 
//
// 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
//输出：34
//解释：你可以选中所有球员。 
//
// 示例 2： 
//
// 输入：scores = [4,5,6,5], ages = [2,1,2,1]
//输出：16
//解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
// 
//
// 示例 3： 
//
// 输入：scores = [1,2,3,5], ages = [8,9,10,1]
//输出：6
//解释：最佳的选择是前 3 名球员。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= scores.length, ages.length <= 1000 
// scores.length == ages.length 
// 1 <= scores[i] <= 106 
// 1 <= ages[i] <= 1000 
// 
// Related Topics 数组 动态规划 排序 
// 👍 53 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: tomster
 * @data: 2021-12-05 14:11:06
 */
public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
        Solution solution = new BestTeamWithNoConflicts().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length;
            int[][] scoreAge = new int[n][2];
            for (int i = 0; i < n; i++) {
                scoreAge[i][0] = scores[i];
                scoreAge[i][1] = ages[i];
            }
            int[] dp = new int[n];
            //年龄升序，分数升序
            Arrays.sort(scoreAge, (o1, o2) -> o1[1] != o2[1]
                    ? Integer.compare(o1[1], o2[1])
                    : Integer.compare(o1[0], o2[0]));
            dp[0] = scoreAge[0][0];
            for (int i = 1; i < n; i++) {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    //年龄小，分数高的不算
                    if (scoreAge[j][0] <= scoreAge[i][0]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + scoreAge[i][0];
            }
            int ans = 0;
            for (int i : dp) {
                ans = Math.max(ans, i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}