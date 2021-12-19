//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 数学 双指针 字符串 
// 👍 178 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-12-19 13:50:37
 */
public class NextGreaterElementIii {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIii().new Solution();
        int i = solution.nextGreaterElement(230241);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nextGreaterElement(int n) {
            StringBuilder sb = new StringBuilder();
            int m = n;
            while (m != 0) {
                sb.append(m % 10);
                m /= 10;
            }
            char[] charArr = sb.reverse().toString().toCharArray();
            int len = sb.length();
            for (int i = len - 1; i >= 1; i--) {
                //从个位开始找，前一位比自己大
                if (charArr[i - 1] < charArr[i]) {
                    //找到里面charArr[i - 1]比他大的最小的数
                    int k = i;
                    for (int j = i + 1; j < len; j++) {
                        if (charArr[j] > charArr[i - 1] && charArr[j] < charArr[k]) {
                            k = j;
                        }
                    }
                    swap(charArr, k, i - 1);//交换
                    Arrays.sort(charArr, i, len);//后面的排序
                    break;
                }
            }
            String target = new String(charArr);
            //int intValue = Integer.parseInt(target);
            long longValue = Long.parseLong(target);
            return (longValue <= Integer.MAX_VALUE && longValue != n) ? (int) longValue : -1;
        }

        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}