//求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回“No solution”。 
//
// 如果方程有无限解，则返回“Infinite solutions”。 
//
// 如果方程中只有一个解，要保证返回值 x 是一个整数。 
//
// 示例 1： 
//
// 输入: "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 输入: "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 输入: "2x=x"
//输出: "x=0"
// 
//
// 示例 4: 
//
// 输入: "2x+3x-6x=x+2"
//输出: "x=-1"
// 
//
// 示例 5: 
//
// 输入: "x=x+2"
//输出: "No solution"
// 
// Related Topics 数学 字符串 模拟 
// 👍 78 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-10-24 13:17:02
 */
public class SolveTheEquation {
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {

            String[] split = equation.split("=");
            String left = split[0];
            String right = split[1];
            Coefficient c1 = parseEquation(left);
            Coefficient c2 = parseEquation(right);
            if (c1.a1 == c2.a1) {
                if (c1.a2 == c2.a2) {
                    return "Infinite solutions";
                } else {
                    return "No solution";
                }
            } else {
                return "x=" + (c2.a2 - c1.a2) / (c1.a1 - c2.a1);
            }
        }

        private Coefficient parseEquation(String equation) {
            String[] postiveSeg = equation.split("\\+");
            Coefficient ce = new Coefficient();
            for (String s : postiveSeg) {
                String[] split = s.split("\\-");
                for (int i = 0; i < split.length; i++) {
                    String cur = split[i];
                    if (cur.endsWith("x")) {
                        int i1 = cur.length() == 1 ? 1 : Integer.parseInt(cur.substring(0, cur.length() - 1));
                        ce.a1 = i == 0 ? ce.a1 + i1 : ce.a1 - i1;
                    } else {
                        int i2 = cur.length() == 0 ? 0 : Integer.parseInt(cur);
                        ce.a2 = i == 0 ? ce.a2 + i2 : ce.a2 - i2;
                    }
                }
            }
            return ce;
        }

        class Coefficient {
            int a1;
            int a2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}