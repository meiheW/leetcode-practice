/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= n <= 10000
 * <p>
 * Related Topics 位运算 递归 脑筋急转弯 👍 543 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-16 20:13:34
 */
public class Qiu12nLcof {
    public static void main(String[] args) {
        Solution solution = new Qiu12nLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNums(int n) {
            if (n == 1) {
                return 1;
            }
            return n + sumNums(n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}