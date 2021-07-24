//返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。 
//
// 如果没有和至少为 K 的非空子数组，返回 -1 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1], K = 1
//输出：1
// 
//
// 示例 2： 
//
// 输入：A = [1,2], K = 4
//输出：-1
// 
//
// 示例 3： 
//
// 输入：A = [2,-1,2], K = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -10 ^ 5 <= A[i] <= 10 ^ 5 
// 1 <= K <= 10 ^ 9 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 
// 👍 289 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: tomster
 * @data: 2021-07-24 22:27:59
 */
public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            Deque<Integer> deque = new ArrayDeque<>();
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n + 1; i++) {
                //严格单调递减
                while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                    deque.pollLast();
                }
                //与队首元素(队列中的最大值)比较，如果满足条件，队首出队列
                while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k) {
                    result = Math.min(result, i - deque.pollFirst());
                }
                deque.add(i);
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}