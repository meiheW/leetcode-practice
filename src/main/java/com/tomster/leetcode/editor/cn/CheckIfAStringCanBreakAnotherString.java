//给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1 的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 
//的一个排列。 
//
// 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序
//）。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "abc", s2 = "xya"
//输出：true
//解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
// 
//
// 示例 2： 
//
// 输入：s1 = "abe", s2 = "acd"
//输出：false 
//解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："a
//cd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排
//列。
// 
//
// 示例 3： 
//
// 输入：s1 = "leetcodee", s2 = "interview"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// s1.length == n 
// s2.length == n 
// 1 <= n <= 10^5 
// 所有字符串都只包含小写英文字母。 
// 
// Related Topics 贪心 字符串 排序 
// 👍 18 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-11 11:40:43
 */
public class CheckIfAStringCanBreakAnotherString {
    public static void main(String[] args) {
        Solution solution = new CheckIfAStringCanBreakAnotherString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1433. 检查一个字符串是否可以打破另一个字符串
         * 思路：字符串字符计数，统计前缀和
         * 前缀和数组各个位置的所有数字都>=或者<=另一个数组
         * 执行耗时:3 ms,击败了100.00% 的Java用户
         * 内存消耗:38.9 MB,击败了91.89% 的Java用户
         */
        public boolean checkIfCanBreak(String s1, String s2) {
            int[] count1 = preCount(s1);
            int[] count2 = preCount(s2);

            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                int diff = count1[i] - count2[i];
                max = Math.max(max, diff);
                min = Math.min(min, diff);
            }
            return max == 0 || min == 0;
        }

        private int[] preCount(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 1; i < 26; i++) {
                count[i] += count[i - 1];
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}