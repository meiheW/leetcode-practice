//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10000 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈 数组 哈希表 前缀和 单调栈 
// 👍 142 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-07-11 23:05:14
 */
public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        Solution solution = new LongestWellPerformingInterval().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 输入：hours = [9,9,6,0,6,6,9]
         * 输出：3
         * 解释：最长的表现良好时间段是 [9,9,6]
         */
        public int longestWPI(int[] hours) {
            int n = hours.length;
            int[] score = new int[n];
            for (int i = 0; i < score.length; i++) {
                score[i] = hours[i] > 8 ? 1 : -1;
            }
            //计算数组前缀和
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + score[i];
            }
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            //严格单调减
            for (int i = 1; i < n; i++) {
                if (stack.isEmpty() || preSum[stack.peek()] > preSum[i]) {
                    stack.push(i);
                }
            }
            //逆序遍历数组求最大长区间
            for (int i = n; i >= 0; i--) {
                while (!stack.isEmpty() && preSum[i] > preSum[stack.peek()]) {
                    result = Math.max(result, i - stack.pop());
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}