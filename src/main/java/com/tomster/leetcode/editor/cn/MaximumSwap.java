//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 贪心 数学 
// 👍 232 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2022-04-13 17:42:23
 */
public class MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        int i = solution.maximumSwap(9973);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            LinkedList<Integer> ll = new LinkedList<>();
            int temp = num;
            while (temp > 0) {
                int cur = temp % 10;
                ll.addFirst(cur);
                temp /= 10;
            }
            for (int i = 0; i < ll.size() - 1; i++) {
                int cur = ll.get(i);
                int max = cur, maxIndex = 0;
                //最后一个最大的数
                for (int j = ll.size() - 1; j > i; j--) {
                    if (ll.get(j) > max) {
                        max = ll.get(j);
                        maxIndex = j;
                    }
                }
                if (max > cur) {
                    ll.set(maxIndex, cur);
                    ll.set(i, max);

                    int sum = 0;
                    for (Integer item : ll) {
                        sum = sum * 10 + item;
                    }
                    return sum;
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}