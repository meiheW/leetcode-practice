/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/
 * Related Topics 位运算 数学 字符串 模拟 👍 49 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 09:00:57
 */
public class JFETK5 {
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int p1 = 0, p2 = 0;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while (p1 < a.length() || p2 < b.length() || carry != 0) {
                int ca = p1 >= a.length() ? 0 : a.charAt(a.length() - 1 - p1) - '0';
                int cb = p2 >= b.length() ? 0 : b.charAt(b.length() - 1 - p2) - '0';
                int sum = ca + cb + carry;
                sb.append(sum % 2);
                carry = sum / 2;
                p1++;
                p2++;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}