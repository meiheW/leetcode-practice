//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 547 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-06-20 00:17:18
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            Stack<Character> stack = new Stack<>();
            boolean[] inStack = new boolean[26];
            for (char cur : s.toCharArray()) {
                if (!inStack[cur - 'a']) {
                    while (!stack.isEmpty() && stack.peek() > cur && map.get(stack.peek()) > 0) {
                        inStack[stack.peek() - 'a'] = false;
                        stack.pop();
                    }
                    stack.push(cur);
                    inStack[cur - 'a'] = true;
                }
                map.put(cur, map.get(cur) - 1);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}