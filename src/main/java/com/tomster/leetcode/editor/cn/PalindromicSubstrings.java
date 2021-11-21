//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 716 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-21 15:51:58
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //中心扩展法
        public int countSubstrings(String s) {
            int ans = 0;
            //考虑子串是基数的情况
            for (int i = 0; i < s.length() - 1; i++) {
                ans += check(s, i, i);
                ans += check(s, i, i + 1);
            }
            ans++;//最后1个
            return ans;
        }

        private int check(String s, int left, int right) {
            int ans = 0;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}