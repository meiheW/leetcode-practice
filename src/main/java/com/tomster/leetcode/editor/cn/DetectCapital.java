//我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如 "USA" 。 
// 单词中所有字母都不是大写，比如 "leetcode" 。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。 
// 
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "USA"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：word = "FlaG"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 由小写和大写英文字母组成 
// 
// Related Topics 字符串 
// 👍 201 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-04-10 18:27:53
 */
public class DetectCapital {
    public static void main(String[] args) {
        Solution solution = new DetectCapital().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            if (word.length() == 1) {
                return true;
            }
            char c = word.charAt(0);
            boolean firstCapital = (c >= 'A' && c <= 'Z');

            if (firstCapital) {
                return isUpperCase(word, 1) || isLowerCase(word, 1);
            } else {
                return isLowerCase(word, 1);
            }
        }

        private boolean isLowerCase(String word, int index) {
            for (int i = index; i < word.length(); i++) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                    return false;
                }
            }
            return true;
        }

        private boolean isUpperCase(String word, int index) {
            for (int i = index; i < word.length(); i++) {
                if (word.charAt(i) < 'A' || word.charAt(i) > 'Z') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}