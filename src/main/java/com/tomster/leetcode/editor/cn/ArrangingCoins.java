//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 182 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 12:03:36
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分
        public int arrangeCoins(int n) {
            int low = 0, high = n;
            while (low <= high) {
                int middle = low + (high - low) / 2;
                long count = (long) (middle + 1) * middle / 2;
                if (count < n) {
                    low = middle + 1;
                } else if (count > n) {
                    high = middle - 1;
                } else {
                    return middle;
                }
            }
            return low - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}