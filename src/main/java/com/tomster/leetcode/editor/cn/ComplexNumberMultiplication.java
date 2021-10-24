//复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件： 
//
// 
// 实部 是一个整数，取值范围是 [-100, 100] 
// 虚部 也是一个整数，取值范围是 [-100, 100] 
// i2 == -1 
// 
//
// 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1+1i", num2 = "1+1i"
//输出："0+2i"
//解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1+-1i", num2 = "1+-1i"
//输出："0+-2i"
//解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
// 
//
// 
//
// 提示： 
//
// 
// num1 和 num2 都是有效的复数表示。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 62 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-10-24 12:35:20
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        Solution solution = new ComplexNumberMultiplication().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            String[] split1 = num1.split("\\+");
            int a1 = Integer.parseInt(split1[0]);
            int b1 = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));

            String[] split2 = num2.split("\\+");
            int a2 = Integer.parseInt(split2[0]);
            int b2 = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));

            int a3 = a1 * a2 - b1 * b2;
            int b3 = a1 * b2 + a2 * b1;
            return a3 + "+" + b3 + "i";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}