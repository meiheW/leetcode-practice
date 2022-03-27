//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1054 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-03-27 17:52:03
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //输入：s = "aab"
        //输出：[["a","a","b"],["aa","b"]]
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            backTracing(s, 0, ans, new ArrayList<>());
            return ans;
        }

        private void backTracing(String s, int index, List<List<String>> ans, List<String> temp) {
            if (index == s.length()) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                String sub = s.substring(index, i + 1);
                if (isPalindrome(sub)) {
                    temp.add(sub);
                    backTracing(s, i + 1, ans, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }


        private boolean isPalindrome(String word) {
            int low = 0;
            int high = word.length() - 1;
            while (low < high) {
                if (word.charAt(low) != word.charAt(high)) {
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