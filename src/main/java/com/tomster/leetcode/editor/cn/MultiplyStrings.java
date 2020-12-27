//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 537 👎 0

package com.tomster.leetcode.editor.cn;

import java.awt.font.NumericShaper;

/**
 * @author: tomster
 * @data: 2020-12-27 21:13:30
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        String multiply = solution.multiply("0", "0");
        System.out.println(multiply);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1 == null || num2 == null) {
                return "";
            }
            int n1 = num1.length() - 1;
            int n2 = num2.length() - 1;
            int[] arr = new int[n1 + n2 + 2];

            for (int i = n1; i >= 0; i--) {
                for (int j = n2; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    mul += arr[i + j + 1];
                    arr[i + j] += mul / 10;
                    arr[i + j + 1] = mul % 10;
                }
            }


            int first = 0;
            //如果全是0，保留最后一个0
            while (first < arr.length-1 && arr[first] == 0) {
                first++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = first; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}