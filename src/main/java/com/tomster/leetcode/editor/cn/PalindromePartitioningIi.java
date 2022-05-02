//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 565 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-05-02 17:25:44
 */
public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            if (n == 1) {
                return 0;
            }
            //dp[i]表示s[0..i]子串字串都是回文的最小分割次数
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                int min = i;
                for (int j = 0; j <= i; j++) {
                    if (isPalindrome(s, j, i)) {
                        min = Math.min(min, j == 0 ? 0 : 1 + dp[j - 1]);
                    }
                }
                dp[i] = min;
            }
            return dp[n - 1];
        }

        private boolean isPalindrome(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    return false;
                }
                low++;
                high--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}