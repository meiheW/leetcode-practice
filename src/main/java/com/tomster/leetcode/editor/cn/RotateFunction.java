//给定一个长度为 n 的整数数组 A 。 
//
// 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为： 
//
// F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。 
//
// 计算F(0), F(1), ..., F(n-1)中的最大值。 
//
// 注意: 
//可以认为 n 的值小于 105。 
//
// 示例: 
//
// 
//A = [4, 3, 2, 6]
//
//F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
//F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
//F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
//F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
//
//所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
// 
// Related Topics 数学 动态规划 
// 👍 94 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-18 22:48:59
 */
public class RotateFunction {
    public static void main(String[] args) {
        Solution solution = new RotateFunction().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划
        //A = [4, 3, 2, 6]
        //
        //F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
        //F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
        //F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
        //F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
        public int maxRotateFunction(int[] nums) {
            int sum = 0;
            int f0 = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                f0 += i * nums[i];
            }

            int[] dp = new int[n];
            dp[0] = f0;
            for (int i = 1; i < n; i++) {
                int incr = sum - nums[n - i];
                int dcr = (n - 1) * nums[n - i];
                dp[i] = dp[i - 1] + incr - dcr;
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}