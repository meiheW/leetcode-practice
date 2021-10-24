//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学 数论 模拟 
// 👍 378 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-10-24 12:27:20
 */
public class AddDigits {
    public static void main(String[] args) {
        Solution solution = new AddDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addDigits(int num) {
            while (num >= 10) {
                int res = 0;
                while (num > 0) {
                    res += num % 10;
                    num /= 10;
                }
                num = res;
            }
            return num;
        }

        /**
         * O(1)方法，我服了 500道
         * 执行耗时:1 ms,击败了100.00% 的Java用户
         * 内存消耗:36 MB,击败了76.24% 的Java用户
         */
        public int addDigits1(int num) {
            return (num - 1) % 9 + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}