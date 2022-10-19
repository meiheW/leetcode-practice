/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 本题中，将空字符串定义为有效的 回文串 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 2 * 10⁵
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/
 * Related Topics 双指针 字符串 👍 34 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 14:43:35
 */
public class XltzEq {
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                    sb.append(c);
                }
            }
            String str = sb.toString().toLowerCase();
            if (str.length() <= 1) {
                return true;
            }
            int low = 0;
            int high = str.length() - 1;
            while (low < high) {
                if (str.charAt(low) != str.charAt(high)) {
                    return false;
                }
                low++;
                high--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}