//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 104 
// 1 <= arr[i] <= 3 * 104 
// 
//
// 
// Related Topics 栈 数组 动态规划 单调栈 
// 👍 255 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-07-07 18:24:43
 */
public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumSubarrayMins(int[] arr) {

            List<Integer> list = new ArrayList<>();
            for (int value : arr) {
                list.add(value);
            }
            list.add(0);
            int base = (int) Math.pow(10, 9) + 7;
            long res = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < list.size(); i++) {
                while (!stack.isEmpty() && list.get(i) <= list.get(stack.peek())) {
                    int index = stack.pop();
                    int preIndex = -1;
                    if (!stack.isEmpty()) {
                        preIndex = stack.peek();
                    }
                    int preCount = index - preIndex - 1;
                    int nextCount = i - index - 1;
                    res += ((long) list.get(index)) * (preCount + 1) * (nextCount + 1) % base;
                    res %= base;
                }
                stack.push(i);
            }
            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}