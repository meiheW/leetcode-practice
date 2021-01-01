//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4769 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-01 16:14:44
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            } else if (s.length() == 1) {
                return 1;
            }
            int p1 = 0;
            int p2 = 1;
            int max = 1;

            while (p2 != s.length()) {
                int index = -1;
                //从p1到p2-1，与p2的值进行比较，index为与之相等的下标
                for (int i = p1; i < p2; i++) {
                    if (s.charAt(i) == s.charAt(p2)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    //p2与之前的都不相等
                    p2++;
                } else {
                    //p2与index相等，则判断max，p1后移以为
                    if (p2 - p1 > max) {
                        max = p2 - p1;
                    }
                    p1 = index + 1;
                }

            }

            return Math.max(max, p2 - p1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}