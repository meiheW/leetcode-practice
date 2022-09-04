/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * Related Topics 数组 数学 👍 249 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-04 17:38:05
 */
public class DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int count = (int) Math.pow(10, n) - 1;
            int[] ans = new int[count];
            for (int i = 0; i < count; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}