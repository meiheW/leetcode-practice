/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length, p.length <= 3 * 10⁴
 * s 和 p 仅包含小写字母
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-
 * string/
 * Related Topics 哈希表 字符串 滑动窗口 👍 38 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-10-19 14:35:25
 */
public class VabMRr {
    public static void main(String[] args) {
        Solution solution = new VabMRr().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (p.length() > s.length()) {
                return ans;
            }
            int[] arr1 = new int[26];
            for (char c : p.toCharArray()) {
                arr1[c - 'a']++;
            }
            int[] arr2 = new int[26];
            int k = p.length();
            for (int i = 0; i < k; i++) {
                arr2[s.charAt(i) - 'a']++;
            }
            if (isPermutation(arr1, arr2)) {
                ans.add(0);
            }
            for (int i = k; i < s.length(); i++) {
                arr2[s.charAt(i) - 'a']++;
                arr2[s.charAt(i - k) - 'a']--;
                if (isPermutation(arr1, arr2)) {
                    ans.add(i - k + 1);
                }
            }
            return ans;
        }

        private boolean isPermutation(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}