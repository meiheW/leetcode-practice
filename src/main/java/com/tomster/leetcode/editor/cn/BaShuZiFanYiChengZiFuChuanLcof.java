/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有
 * 多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= num < 2³¹
 * <p>
 * Related Topics 字符串 动态规划 👍 484 👎 0
 */
package com.tomster.leetcode.editor.cn;


/**
 * @author: tomster
 * @data: 2022-09-12 14:40:43
 */
public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        int ans = solution.translateNum(12258);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            char[] arr = Integer.toString(num).toCharArray();
            int n = arr.length;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] += dp[i - 1];
                if (arr[i - 2] == '1' || (arr[i - 2] == '2' && arr[i - 1] < '6')) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}