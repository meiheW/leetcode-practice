/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * Related Topics 字符串 👍 342 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-02 16:42:23
 */
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c == ' ' ? "%20" : c);
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}