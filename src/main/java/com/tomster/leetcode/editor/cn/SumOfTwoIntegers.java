//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 2
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics 位运算 数学 
// 👍 564 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-12 19:59:41
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new SumOfTwoIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            //位运算
            while ((a & b) != 0) {
                int xor = a ^ b;
                int carry = a & b;
                a = xor;
                b = carry << 1;
            }
            return a ^ b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}