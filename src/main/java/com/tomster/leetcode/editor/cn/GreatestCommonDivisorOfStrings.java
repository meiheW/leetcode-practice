//对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。 
//
// 
//
// 示例 1： 
//
// 
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length <= 1000 
// 1 <= str2.length <= 1000 
// str1[i] 和 str2[i] 为大写英文字母 
// 
// Related Topics 数学 字符串 
// 👍 217 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 16:59:54
 */
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        Solution solution = new GreatestCommonDivisorOfStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (!str1.concat(str2).equals(str2.concat(str1))) {
                return "";
            }
            int gcd = gcd(str1.length(), str2.length());
            return str1.substring(0, gcd);
        }

        private int gcd(int m, int n) {
            if (n == 0) {
                return m;
            } else {
                return gcd(n, m % n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}