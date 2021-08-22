//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 596 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-08-22 17:50:09
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口
        public List<Integer> findAnagrams(String s, String p) {
            int m = s.length();
            int n = p.length();
            List<Integer> res = new ArrayList<>();
            if (m < n) {
                return res;
            }
            int[] cnt_p = new int[26];
            int[] cnt_s = new int[26];
            for (int i = 0; i < n; i++) {
                cnt_p[p.charAt(i) - 'a']++;
                cnt_s[s.charAt(i) - 'a']++;
            }
            if (Arrays.equals(cnt_s, cnt_p)) {
                res.add(0);
            }

            for (int i = n; i < m; i++) {
                cnt_s[s.charAt(i) - 'a']++;
                cnt_s[s.charAt(i - n) - 'a']--;
                if (Arrays.equals(cnt_s, cnt_p)) {
                    res.add(i - n + 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}