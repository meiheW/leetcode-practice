//给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asu
//ffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bpref
//ix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。 
//
// 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么
// "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。 
//
// 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。 
//
// 注意， x + y 表示连接字符串 x 和 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = "x", b = "y"
//输出：true
//解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
//aprefix = "", asuffix = "x"
//bprefix = "", bsuffix = "y"
//那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：a = "abdef", b = "fecab"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：a = "ulacfd", b = "jizalu"
//输出：true
//解释：在下标为 3 处分割：
//aprefix = "ula", asuffix = "cfd"
//bprefix = "jiz", bsuffix = "alu"
//那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。 
//
// 示例 4： 
//
// 
//输入：a = "xbdef", b = "xecab"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 105 
// a.length == b.length 
// a 和 b 都只包含小写英文字母 
// 
// Related Topics 贪心 双指针 字符串 
// 👍 37 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-21 12:32:24
 */
public class SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
        Solution solution = new SplitTwoStringsToMakePalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            int left = a.length() - 1;
            left = Math.min(check(a, a, left), check(b, b, left));
            left = Math.min(check(a, b, left), check(b, a, left));
            return left == -1;
        }

        private int check(String a, String b, int left) {
            int right = a.length() - 1 - left;
            while (left >= 0) {
                if (a.charAt(left) != b.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}