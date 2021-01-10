//验证给定的字符串是否可以解释为十进制数字。 
//
// 例如: 
//
// "0" => true 
//" 0.1 " => true 
//"abc" => false 
//"1 a" => false 
//"2e10" => true 
//" -90e3 " => true 
//" 1e" => false 
//"e3" => false 
//" 6e-1" => true 
//" 99e2.5 " => false 
//"53.5e93" => true 
//" --6 " => false 
//"-+3" => false 
//"95a54e53" => false 
//
// 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表： 
//
// 
// 数字 0-9 
// 指数 - "e" 
// 正/负号 - "+"/"-" 
// 小数点 - "." 
// 
//
// 当然，在输入中，这些字符的上下文也很重要。 
//
// 更新于 2015-02-10: 
//C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。 
// Related Topics 数学 字符串 
// 👍 167 👎 0

package com.tomster.leetcode.editor.cn;

import java.awt.*;
import java.util.zip.CheckedInputStream;

/**
 * @author: tomster
 * @data: 2021-01-10 16:25:38
 */
public class ValidNumber {
    public static void main(String[] args) {
        Solution solution = new ValidNumber().new Solution();
        boolean e3 = solution.isNumber("0");
        System.out.println(e3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 参考https://leetcode-cn.com/problems/valid-number/solution/java-luo-ji-chao-qing-xi-jie-fa-by-charlesgao/
         * 从这个解题思路可以发现判断一个式子是不是十进制或者科学计数法，有O(N)方法
         * 可以增加标记判断一些字符是否出现，来判断是否正确
         *
         * @param s
         * @return
         */
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
                } else if (arr[i] == 'e') {
                    if (eSeen || !numSeen) {
                        return false;
                    }
                    eSeen = true;
                    numSeen = false;//重要
                } else if (arr[i] == '+' || arr[i] == '-') {
                    if (i != 0 && arr[i - 1] != 'e') {
                        return false;
                    }
                } else {
                    //出现其他字符直接false
                    return false;
                }


            }

            return numSeen;
        }


        /**
         * 个人方法如下，先后判断空格，e，小数点的情况，遍历次数较多，较复杂
         * 看到两种方法，一种是O(N),遍历一次，然后加标记falg来做，
         * 还有一种是官方答案 有限状态机（DFA）
         *
         * @param s
         * @return
         */
        public boolean isNumber1(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            //处理空格问题
            String trim = s.trim();
            if (trim.length() == 0) {
                return false;
            }
            for (int i = 0; i < trim.length(); i++) {
                if (trim.charAt(i) == ' ') {
                    return false;
                }
            }
            //处理e
            int indexE = trim.indexOf('e');
            if (indexE == -1) {
                return checkA(trim);
            }

            if (indexE != trim.lastIndexOf('e')) {
                return false;
            }
            String a = trim.substring(0, indexE);
            String b = trim.substring(indexE + 1);

            return checkA(a) && checkB(b);
        }

        private boolean checkB(String t) {
            if (t == null || t.length() == 0) {
                return false;
            }
            boolean res = false;
            for (int i = 0; i < t.length(); i++) {
                //+ / -
                if (t.charAt(i) == '+' || t.charAt(i) == '-') {
                    if (i != 0) {
                        return false;
                    }
                } else if (t.charAt(i) < '0' || t.charAt(i) > '9') {
                    return false;
                } else {
                    res = true;
                }

            }

            return res;
        }

        private boolean checkA(String t) {
            if (t == null || t.length() == 0) {
                return false;
            }
            boolean dPoint = false;
            boolean res = false;
            for (int i = 0; i < t.length(); i++) {
                //+ / -
                if (t.charAt(i) == '+' || t.charAt(i) == '-') {
                    if (i != 0) {
                        return false;
                    }
                } else if (t.charAt(i) == '.') {
                    if (dPoint) {
                        return false;
                    } else {
                        dPoint = true;
                    }
                } else if (t.charAt(i) < '0' || t.charAt(i) > '9') {
                    return false;
                } else {
                    res = true;
                }

            }

            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}