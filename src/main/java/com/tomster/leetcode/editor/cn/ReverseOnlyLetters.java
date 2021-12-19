//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 双指针 字符串 
// 👍 97 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 20:51:31
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            char[] charArray = s.toCharArray();
            int low = 0, high = charArray.length - 1;
            while (low < high) {
                while (low < high && !Character.isLetter(charArray[low])) {
                    low++;
                }
                while (low < high && !Character.isLetter(charArray[high])) {
                    high--;
                }
                if (low < high) {
                    char temp = charArray[low];
                    charArray[low] = charArray[high];
                    charArray[high] = temp;
                    low++;
                    high--;
                }
            }
            return new String(charArray);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}