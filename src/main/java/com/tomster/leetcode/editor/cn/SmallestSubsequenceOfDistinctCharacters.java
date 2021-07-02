//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
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
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心 字符串 单调栈 
// 👍 102 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-07-02 18:29:52
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestSubsequence(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : chars) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];
        for (char c : chars) {
            if (!inStack[c - 'a']) {
                while (!stack.isEmpty() && stack.peek() > c && freq.get(stack.peek()) > 0) {
                    char pop = stack.pop();
                    inStack[pop - 'a'] = false;
                }
                stack.push(c);
                inStack[c - 'a'] = true;
            }
            freq.put(c, freq.get(c) - 1);
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