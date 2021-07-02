//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
// Related Topics 栈 字符串 
// 👍 221 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-07-02 15:38:28
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(0);
                } else {
                    Integer pop0 = stack.pop();
                    Integer pop1 = stack.pop();
                    stack.push(pop1 + Math.max(1, 2 * pop0));
                }
            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}