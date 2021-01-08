//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 538 👎 0

package com.tomster.leetcode.editor.cn;
/**
 * @author: tomster
 * @data: 2021-01-09 01:20:38
 */
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return a == null || a.length() == 0 ? b : a;
        }
        int maxLen = Math.max(a.length(), b.length());
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int indexA = lenA - i - 1;
            int indexB = lenB - i - 1;
            int intA = indexA >= 0 ? a.charAt(indexA) - '0' : 0;
            int intB = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
            int sum = intA + intB + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}