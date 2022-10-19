/**
 * /**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-
 * repeating-characters/
 * Related Topics 哈希表 字符串 滑动窗口 👍 59 👎 0
 */


package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 14:39:20
 */
public class WtcaE1 {
    public static void main(String[] args) {
        Solution solution = new WtcaE1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            } else if (s.length() == 1) {
                return 1;
            }
            int p0 = 0, p1 = 1, ans = 1;
            char[] arr = s.toCharArray();
            while (p1 != arr.length) {
                int p = p1 - 1;
                while (p >= p0 && arr[p] != arr[p1]) {
                    p--;
                }
                if (p == p0 - 1) {
                    ans = Math.max(ans, p1 - p0 + 1);
                } else {
                    p0 = p + 1;
                }
                p1++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}