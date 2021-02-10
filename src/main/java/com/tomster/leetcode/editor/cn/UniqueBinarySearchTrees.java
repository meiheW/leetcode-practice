//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 995 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-02-10 23:48:10
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         * 卡特兰数公式 : G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
         * @param n
         * @return
         */
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = 0;
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - 1 - j];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}