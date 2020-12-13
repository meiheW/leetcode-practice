//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2042 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author: tomster
 * @data: 2020-12-13 23:56:05
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() && isMatch(s.charAt(i), stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(Character c, Character peek) {
            return peek == '{' && c == '}'
                    ||
                    peek == '[' && c == ']'
                    ||
                    peek == '(' && c == ')';


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}