//给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。 
//
// 重复出现（不同位置）的子串也要统计它们出现的次数。 
// 
//
// 示例 1： 
//
// 
//输入：s = "00110011"
//输出：6
//解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
//注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
//另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。 
//
// 示例 2： 
//
// 
//输入：s = "10101"
//输出：4
//解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 为 '0' 或 '1' 
// 
// Related Topics 双指针 字符串 
// 👍 421 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-25 21:21:18
 */
public class CountBinarySubstrings {
    public static void main(String[] args) {
        Solution solution = new CountBinarySubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            int p0 = 0, p1 = 0, pre = 0, ans = 0;
            while (p0 < s.length()) {
                p1 = p0;
                int cnt = 0;
                while (p1 < s.length() && s.charAt(p1) == s.charAt(p0)) {
                    p1++;
                    cnt++;
                }
                ans += Math.min(pre, cnt);
                pre = cnt;
                p0 = p1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}