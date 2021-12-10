//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1036 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: tomster
 * @data: 2020-12-13 14:39:03
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return ans;
            }
            backTracing(ans, new StringBuilder(), digits, 0);
            return ans;
        }

        private void backTracing(List<String> ans, StringBuilder temp, String digits, int start) {
            if (temp.length() == digits.length()) {
                ans.add(temp.toString());
                return;
            }
            char c = digits.charAt(start);
            char[] chars = getChars(c);
            for (int i = 0; i < chars.length; i++) {
                temp.append(chars[i]);
                backTracing(ans, temp, digits, start + 1);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

        char[] getChars(char i) {
            switch (i) {
                case '2':
                    return new char[]{'a', 'b', 'c'};
                case '3':
                    return new char[]{'d', 'e', 'f'};
                case '4':
                    return new char[]{'g', 'h', 'i'};
                case '5':
                    return new char[]{'j', 'k', 'l'};
                case '6':
                    return new char[]{'m', 'n', 'o'};
                case '7':
                    return new char[]{'p', 'q', 'r', 's'};
                case '8':
                    return new char[]{'t', 'u', 'v'};
                case '9':
                    return new char[]{'w', 'x', 'y', 'z'};
                default:
                    return null;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}