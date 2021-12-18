//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 650 👎 0

package com.tomster.leetcode.editor.cn;

import javax.sound.midi.Soundbank;

/**
 * @author: tomster
 * @data: 2021-12-18 13:53:50
 */
public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        int i = solution.integerBreak(10);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入: 10   输出: 36
        //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                int max = 0;
                for (int j = 1; j < i; j++) {
                    max = Math.max(max, j * Math.max(dp[i - j], i - j));
                }
                dp[i] = max;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}