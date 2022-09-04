/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * <p>
 * <p>
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * <p>
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * <p>
 * <p>
 * <p>
 * <p>
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * <p>
 * 部分数值列举如下：
 * <p>
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * <p>
 * <p>
 * 部分非数值列举如下：
 * <p>
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "0"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "e"
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "."
 * 输出：false
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "    .1  "
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 * <p>
 * Related Topics 字符串 👍 385 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-04 17:48:51
 */
public class BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        boolean flag = solution.isNumber("-1E-16");
        System.out.println(flag);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            boolean numSeen = false;
            boolean dotSeen = false;
            boolean eSeen = false;
            char[] arr = s.trim().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    numSeen = true;
                } else if (arr[i] == '.') {
                    if (dotSeen || eSeen) {
                        return false;
                    }
                    dotSeen = true;
                } else if (arr[i] == 'e' || arr[i] == 'E') {
                    if (eSeen || !numSeen) {
                        return false;
                    }
                    eSeen = true;
                    numSeen = false;//重要
                } else if (arr[i] == '+' || arr[i] == '-') {
                    if (i != 0 && (arr[i - 1] != 'e' && arr[i - 1] != 'E')) {
                        return false;
                    }
                } else {
                    //出现其他字符直接false
                    return false;
                }
            }
            return numSeen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}