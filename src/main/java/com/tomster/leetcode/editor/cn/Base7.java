//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -107 <= num <= 107 
// 
// Related Topics 数学 
// 👍 107 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 12:49:47
 */
public class Base7 {
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            boolean sign = num > 0;
            num = Math.abs(num);
            while (num != 0) {
                sb.append(num % 7);
                num /= 7;
            }
            return (!sign ? "-" : "") + sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}