/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返
 * 回左旋转两位得到的结果"cdefgab"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= k < s.length <= 10000
 * <p>
 * Related Topics 数学 双指针 字符串 👍 308 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-14 18:34:37
 */
public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            assert n >= 1 && n <= s.length();
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(n));
            sb.append(s.substring(0, n));
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}