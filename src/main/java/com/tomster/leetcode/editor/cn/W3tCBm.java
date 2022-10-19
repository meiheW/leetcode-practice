/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * <p>
 * <p>
 * 说明 :
 * <p>
 * <p>
 * 0 <= n <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶:
 * <p>
 * <p>
 * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
 * 要求算法的空间复杂度为 O(n) 。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 338 题相同：https://leetcode-cn.com/problems/counting-bits/
 * Related Topics 位运算 动态规划 👍 103 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 09:12:26
 */
public class W3tCBm {
    public static void main(String[] args) {
        Solution solution = new W3tCBm().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                ans[i] = Integer.bitCount(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}