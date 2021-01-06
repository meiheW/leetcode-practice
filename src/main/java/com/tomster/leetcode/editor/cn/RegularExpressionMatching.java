//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1763 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-03 21:32:45
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        boolean match = solution.isMatch("aa", "a");
        System.out.println(match);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param s
         * @param p 正则表达式：.代表任意字符  *代表0个或多个前面那个字符
         * @return
         */
        public boolean isMatch(String s, String p) {
            if (p == null || p.length() == 0) {
                return s == null || s.length() == 0;
            }
            //字符串为列，正则表达式为行
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            //第一行数据初始化
            for (int i = 2; i <= p.length(); i++) {
                //注意下标，i-1，不是i，因为dp矩阵边缘加了一层
                dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    //正则当前字符与字符串相同或等于.
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        //正则当前字符为*，*可以匹配0，匹配n个p.charAt(j - 2)字符
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                    }
                }
            }

            return dp[s.length()][p.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}