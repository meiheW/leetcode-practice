//给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：true
// 
//
// 示例 2： 
//
// 输入：10
//输出：false
// 
//
// 示例 3： 
//
// 输入：16
//输出：true
// 
//
// 示例 4： 
//
// 输入：24
//输出：false
// 
//
// 示例 5： 
//
// 输入：46
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 计数 枚举 排序 
// 👍 140 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-28 14:36:08
 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        Solution solution = new ReorderedPowerOf2().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 计数，其实是一样的，就是同构字符串题型
         */
        public boolean reorderedPowerOf2(int n) {
            int[] arr = count(n);
            int num = 1;
            int limit = (int) Math.pow(10, 9);
            while (num < limit) {
                if (Arrays.equals(arr, count(num))) {
                    return true;
                }
                num *= 2;
            }
            return false;
        }

        private int[] count(int n) {
            int[] count = new int[10];
            while (n > 0) {
                count[n % 10]++;
                n /= 10;
            }
            return count;
        }

        /**
         * 我的解法，还可以，我比较喜欢用字符串
         */
        public boolean reorderedPowerOf2_1(int n) {
            int len = intLen(n);
            String str = intStr(n);
            int num = 1;
            int limit = (int) Math.pow(10, 9);
            while (num < limit && len >= intLen(num)) {
                if (intStr(num).equals(str)) {
                    return true;
                }
                num *= 2;
            }
            return false;
        }

        private String intStr(int n) {
            int len = intLen(n);
            char[] arr = new char[len];
            int i = 0;
            while (n > 0) {
                arr[i++] = (char) ('0' + (n % 10));
                n /= 10;
            }
            Arrays.sort(arr);
            return new String(arr);
        }

        private int intLen(int n) {
            int res = 0;
            while (n > 0) {
                res++;
                n /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}