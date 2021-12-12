//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 数学 字符串 
// 👍 501 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-12-12 19:43:58
 */
public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Character> operators = Arrays.asList('+', '-', '*', '/');

        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            s = s.replace(" ", "");
            char[] arr = s.toCharArray();
            int p = 0;
            if (!operators.contains(s.charAt(0))) {
                StringBuilder sb = new StringBuilder();
                while (p < s.length() && !operators.contains(arr[p])) {
                    sb.append(arr[p++]);
                }
                stack.push(Integer.parseInt(sb.toString()));
            }
            while (p < s.length()) {
                char operator = arr[p];
                StringBuilder sb = new StringBuilder();
                while (++p < s.length() && !operators.contains(arr[p])) {
                    sb.append(arr[p]);
                }
                int num = Integer.parseInt(sb.toString());
                switch (operator) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push((stack.isEmpty() ? 0 : stack.pop()) * num);
                        break;
                    case '/':
                        stack.push((stack.isEmpty() ? 0 : stack.pop()) / num);
                        break;
                }
            }

            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}