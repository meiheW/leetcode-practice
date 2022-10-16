/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输
 * 出"student. a am I"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>
 * 注意：此题对比原题有改动
 * Related Topics 双指针 字符串 👍 246 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-10-14 18:30:32
 */
public class FanZhuanDanCiShunXuLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanDanCiShunXuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            List<String> strList = new ArrayList<>();
            int p0 = 0, p1 = 0;
            while (p0 < s.length()) {
                while (p0 < s.length() && s.charAt(p0) == ' ') {
                    p0++;
                }
                p1 = p0;
                while (p1 < s.length() && s.charAt(p1) != ' ') {
                    p1++;
                }
                if (p0 != p1) {
                    strList.add(s.substring(p0, p1));
                }
                p0 = p1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = strList.size() - 1; i >= 0; i--) {
                sb.append(strList.get(i)).append(" ");
            }
            return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}