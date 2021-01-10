//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 570 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-10 20:43:26
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        int i = solution.mySqrt(8);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二份查找来做溢出，改为long long
         *
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            int low = 0;
            int high = x;
            while (high - low > 1) {
                int middle = (low + high) / 2;
                long square = (long) middle * middle;
                if (square == x) {
                    return middle;
                } else if (square < x) {
                    low = middle;
                } else {
                    high = middle;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}