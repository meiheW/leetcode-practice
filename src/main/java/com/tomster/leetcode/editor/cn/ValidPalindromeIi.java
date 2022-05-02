//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 105 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 
// 👍 436 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-25 20:45:26
 */
public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            return (s == null || s.length() <= 1) || isValid(s, 1);
        }

        private boolean isValid(String s, int cnt) {
            int low = 0;
            int high = s.length() - 1;
            while (low < high) {
                if (s.charAt(low) == s.charAt(high)) {
                    low++;
                    high--;
                } else {
                    if (cnt == 0) {
                        return false;
                    } else {
                        --cnt;
                        return isValid(s.substring(low, high), cnt)
                                || isValid(s.substring(low + 1, high + 1), cnt);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}