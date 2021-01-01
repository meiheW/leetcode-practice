//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 3052 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-01 20:00:53
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 最长回文串这种上来就是dp
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int right = 0, left = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = true;
                for (int j = i + 1; j < n; j++) {
                    //(i,j)包括j的子串是回文串的条件
                    dp[i][j] = (dp[i + 1][j - 1] || j - i <= 2) && s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }

            return s.substring(left, right + 1);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}