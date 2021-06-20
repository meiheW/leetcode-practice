//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 789 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-06-20 15:11:21
 */
public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (c != ']') {
                    stack.push(c);
                } else {
                    StringBuilder str = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek() != '[') {
                        str.append(stack.pop());
                    }
                    str.reverse();
                    stack.pop();
                    StringBuilder timesStr = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                        timesStr.append(stack.pop());
                    }
                    int times = Integer.parseInt(timesStr.reverse().toString());
                    for (int i = 0; i < times; i++) {
                        for (int j = 0; j < str.length(); j++) {
                            stack.push(str.charAt(j));
                        }
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            return result.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}