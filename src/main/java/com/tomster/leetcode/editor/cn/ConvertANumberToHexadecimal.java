//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
//
// 注意: 
//
// 
// 十六进制中所有字母(a-f)都必须是小写。 
// 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
// 给定的数确保在32位有符号整数范围内。 
// 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。 
// 
//
// 示例 1： 
//
// 
//输入:
//26
//
//输出:
//"1a"
// 
//
// 示例 2： 
//
// 
//输入:
//-1
//
//输出:
//"ffffffff"
// 
// Related Topics 位运算 数学 
// 👍 224 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-18 22:51:38
 */
public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 7; i >= 0; i--) {
                int val = (num >> i * 4) & 0xf;
                //去掉前导0，有点意思
                if (val > 0 || sb.length() > 0) {
                    char c = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}