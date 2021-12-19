//在一根无限长的数轴上，你站在0的位置。终点在target的位置。 
//
// 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。 
//
// 返回到达终点需要的最小移动次数。 
//
// 示例 1: 
//
// 
//输入: target = 3
//输出: 2
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 3 。
// 
//
// 示例 2: 
//
// 
//输入: target = 2
//输出: 3
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 -1 。
//第三次移动，从 -1 到 2 。
// 
//
// 注意: 
//
// 
// target是在[-10^9, 10^9]范围中的非零整数。 
// 
// Related Topics 数学 二分查找 
// 👍 164 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 15:56:13
 */
public class ReachANumber {
    public static void main(String[] args) {
        Solution solution = new ReachANumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 题意即为，有数组1，2，3，4，5...,i；给数组元素添加正负号，和为target的最小数组长度
         * 正号和m，负号和n，则m+n=s, m-n=target
         * 两式相减得，s-target = 2*n;即满足这个s-target为偶数的最小长度
         * s = (i+1)*i/2,s-target为偶数
         *
         * @param target
         * @return
         */
        public int reachNumber(int target) {
            if (target < 0) {
                target = -target;
            }
            int i = 1;
            while (true) {
                int s = (i + 1) * i / 2;
                if (s >= target && (s - target) % 2 == 0) {
                    return i;
                }
                i++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}