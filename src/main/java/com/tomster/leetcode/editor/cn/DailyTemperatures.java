//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 788 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-06-22 23:24:20
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 要想观测到更高的气温，至少需要等待的天数
         * @param temperatures [73, 74, 75, 71, 69, 72, 76, 73]
         * @return [1, 1, 4, 2, 1, 1, 0, 0]
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = temperatures.length - 1; i >= 0; i--) {
                int curTemp = temperatures[i];
                while (!stack.isEmpty() && temperatures[stack.peek()] <= curTemp) {
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}