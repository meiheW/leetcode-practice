/**
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s 由小写英文字母组成
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/
 * Related Topics 贪心 双指针 字符串 👍 54 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 14:44:48
 */
public class RQku0D {
    public static void main(String[] args) {
        Solution solution = new RQku0D().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int low = 0, high = s.length() - 1;
            while (low < high) {
                if (s.charAt(low) == s.charAt(high)) {
                    low++;
                    high--;
                } else {
                    return validPalindrome(s, low + 1, high) || validPalindrome(s, low, high - 1);
                }
            }
            return true;
        }

        private boolean validPalindrome(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low) == s.charAt(high)) {
                    low++;
                    high--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}