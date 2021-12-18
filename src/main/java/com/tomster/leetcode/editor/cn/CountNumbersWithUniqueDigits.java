//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯 
// 👍 167 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-18 15:06:01
 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 10;
            }
            int count = 9;  // 9 9 8 7 ...
            for (int j = 0; j < n - 1; j++) {
                count *= (9 - j);
            }
            return count + countNumbersWithUniqueDigits(n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}