//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 数组 数学 枚举 数论 
// 👍 793 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-12-07 22:30:48
 */
public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            int ans = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    ans++;
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = false;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}