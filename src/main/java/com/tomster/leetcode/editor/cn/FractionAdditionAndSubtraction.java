//给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，
//你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。 
//
// 示例 1: 
//
// 
//输入:"-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入:"-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入:"1/3-1/2"
//输出: "-1/6"
// 
//
// 示例 4: 
//
// 
//输入:"5/3+1/3"
//输出: "2/1"
// 
//
// 说明: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 55 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Scanner;

/**
 * @author: tomster
 * @data: 2021-10-30 10:26:55
 */
public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        Solution solution = new FractionAdditionAndSubtraction().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionAddition(String expression) {
            Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
            int A = 0, B = 1;
            while (sc.hasNext()) {
                int a = sc.nextInt(), b = sc.nextInt();
                A = A * b + a * B;
                B *= b;
                int g = gcd(A, B);
                A /= g;
                B /= g;
            }
            return A + "/" + B;
        }

        private int gcd(int a, int b) {
            return a != 0 ? gcd(b % a, a) : Math.abs(b);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}