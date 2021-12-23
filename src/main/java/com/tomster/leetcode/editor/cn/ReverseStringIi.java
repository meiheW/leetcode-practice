//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文组成 
// 1 <= k <= 104 
// 
// Related Topics 双指针 字符串 
// 👍 226 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-23 22:11:30
 */
public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] charArr = s.toCharArray();
            int p = 0;
            while (p < charArr.length) {
                //翻转前k个字符
                swapK(charArr, k, p);
                //往前移动k个位置
                p += 2 * k;
            }
            return new String(charArr);
        }

        private void swapK(char[] charArr, int k, int p) {
            int low = p;
            int high = Math.min(k + p - 1, charArr.length - 1);
            while (low < high) {
                char temp = charArr[low];
                charArr[low] = charArr[high];
                charArr[high] = temp;
                low++;
                high--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}