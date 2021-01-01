//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 952 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-01 20:29:28
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (s == null || s.length() == 0 || numRows == 0) {
                return s;
            }
            StringBuffer[] sbs = new StringBuffer[numRows];
            for (int i = 0; i < numRows; i++) {
                sbs[i] = new StringBuffer();
            }

            int rowIndex = 0;
            boolean downward = true;
            for (int i = 0; i < s.length(); i++) {
                StringBuffer sb = sbs[rowIndex];
                sb.append(s.charAt(i));
                if (i != 0 && numRows > 1 && i % (numRows - 1) == 0) {
                    downward = !downward;
                }
                rowIndex = downward ? ++rowIndex : --rowIndex;
                rowIndex = rowIndex < 0 ? 0 : Math.min(rowIndex, numRows - 1);
            }
            StringBuffer res = new StringBuffer();
            for (int i = 0; i < sbs.length; i++) {
                res.append(sbs[i]);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}