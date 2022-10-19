/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 10⁴
 * s1 和 s2 仅包含小写字母
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/
 * Related Topics 哈希表 双指针 字符串 滑动窗口 👍 70 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 14:34:09
 */
public class MPnaiL {
    public static void main(String[] args) {
        Solution solution = new MPnaiL().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            for (char c : s1.toCharArray()) {
                arr1[c - 'a']++;
            }
            int k = s1.length();
            for (int i = 0; i < k; i++) {
                arr2[s2.charAt(i) - 'a']++;
            }
            if (isPermutation(arr1, arr2)) {
                return true;
            }
            for (int i = k; i < s2.length(); i++) {
                arr2[s2.charAt(i) - 'a']++;
                arr2[s2.charAt(i - k) - 'a']--;
                if (isPermutation(arr1, arr2)) {
                    return true;
                }
            }
            return false;
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