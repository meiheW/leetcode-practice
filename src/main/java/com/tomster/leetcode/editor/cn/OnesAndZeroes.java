//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 数组 字符串 动态规划 
// 👍 668 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-03-17 17:23:49
 */
public class OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
        //输出：4
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            //dp[k][m][n]表示前k个字符串用m个0和n个1能获取到的最长子集长度
            int[][][] dp = new int[len + 1][m + 1][n + 1];
            for (int k = 1; k <= len; k++) {
                int[] zerosOnes = getZerosOnes(strs[k - 1]);
                int zeros = zerosOnes[0], ones = zerosOnes[1];
                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        dp[k][i][j] = dp[k - 1][i][j];
                        if (i >= zeros && j >= ones) {
                            dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i - zeros][j - ones] + 1);
                        }
                    }
                }
            }
            return dp[len][m][n];
        }

        public int[] getZerosOnes(String str) {
            int[] zerosOnes = new int[2];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                zerosOnes[str.charAt(i) - '0']++;
            }
            return zerosOnes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}