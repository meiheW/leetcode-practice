//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 230 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-12-19 20:29:49
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        //和官方题解一致
        public String reverseVowels(String s) {
            char[] arr = s.toCharArray();
            int n = s.length();

            int low = 0;
            int high = n - 1;
            while (low < high) {
                //部分题目就是这样，有特殊条件就要先把指针移动到符合要求的地方
                while (low < n && !vowels.contains(arr[low])) {
                    low++;
                }
                while (high >= 0 && !vowels.contains(arr[high])) {
                    high--;
                }
                if (low < high) {
                    char temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    low++;
                    high--;
                }
            }
            return new String(arr);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}