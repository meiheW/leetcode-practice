//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 1119 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2020-12-27 12:56:39
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划，简单易懂
         * dp[i]表示以s.charAt(i)为结尾的最大匹配长度
         *
         * @param s
         * @return
         */
        public int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) {
                return 0;
            }
            int result = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        //...()
                        dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                    } else {
                        //...((...))
                        if (dp[i - 1] > 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 1 - 1 >= 0 ? dp[i - dp[i - 1] - 1 - 1] : 0);
                        }
                    }

                }
                result = Math.max(result, dp[i]);
            }

            return result;
        }

        /**
         * 我的思路：
         * 用字符串构建一个字符数组，index从0到最后遍历
         * 与前面第一个不是‘0’的字符匹配，如果没有匹配上就不变，匹配上了两个字符都变为‘0’
         * 然后统计字符数组中连续0的个数，即满足题目要求
         *
         * @param s
         * @return
         */
        public int longestValidParentheses_1(String s) {
            Map<Character, Character> map = new HashMap<>(3);
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            if (s == null || s.length() <= 1) {
                return 0;
            }
            char[] chars = s.toCharArray();
            //将匹配上的括号改成0
            for (int i = 1; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    continue;
                }
                int k = i - 1;
                while (k >= 0 && chars[k] == '0') {
                    k--;
                }
                if (k == -1) {
                    continue;
                }
                Character a = map.get(chars[k]);
                if (a != null && a == chars[i]) {
                    chars[k] = '0';
                    chars[i] = '0';
                }
            }

            //遍历数组，求出最长的长度值
            int len = 0;
            int start = -1;
            boolean started = false;
            for (int i = 0; i < chars.length; i++) {
                if (!started) {
                    if (chars[i] == '0') {
                        start = i;
                        started = true;
                    }
                } else {
                    if (chars[i] != '0') {
                        len = Math.max(i - start, len);
                        started = false;
                    }

                }


            }
            if (started) {
                len = Math.max(chars.length - start, len);
            }
            return len;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}