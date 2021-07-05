//给你一个字符串 s ，请你判断它是否 有效 。
// 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ： 
//
// 
// 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + trigh
//t 。注意，tleft 和 tright 可能为 空 。 
// 
//
// 如果字符串 s 有效，则返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcbc"
//输出：true
//解释：
//"" -> "abc" -> "aabcbc"
//因此，"aabcbc" 有效。 
//
// 示例 2： 
//
// 
//输入：s = "abcabcababcc"
//输出：true
//解释：
//"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
//因此，"abcabcababcc" 有效。 
//
// 示例 3： 
//
// 
//输入：s = "abccba"
//输出：false
//解释：执行操作无法得到 "abccba" 。 
//
// 示例 4： 
//
// 
//输入：s = "cababc"
//输出：false
//解释：执行操作无法得到 "cababc" 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 104 
// s 由字母 'a'、'b' 和 'c' 组成 
// 
// Related Topics 栈 字符串 
// 👍 50 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2021-07-05 15:53:59
 */
public class CheckIfWordIsValidAfterSubstitutions {
    public static void main(String[] args) {
        Solution solution = new CheckIfWordIsValidAfterSubstitutions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            LinkedList<Character> deque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (s.charAt(i) == 'c') {
                    if (deque.size() < 2 || deque.get(deque.size() - 2) != 'a' || deque.get(deque.size() - 1) != 'b') {
                        return false;
                    }
                    deque.pollLast();
                    deque.pollLast();
                } else {
                    deque.addLast(cur);
                }
            }
            return deque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}