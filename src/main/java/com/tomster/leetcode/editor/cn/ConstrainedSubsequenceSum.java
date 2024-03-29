//给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：子序列中每两个 相邻 的整数 nums[i] 和 num
//s[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。 
//
// 数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [10,2,-10,5,20], k = 2
//输出：37
//解释：子序列为 [10, 2, 5, 20] 。
// 
//
// 示例 2： 
//
// 输入：nums = [-1,-2,-3], k = 1
//输出：-1
//解释：子序列必须是非空的，所以我们选择最大的数字。
// 
//
// 示例 3： 
//
// 输入：nums = [10,-2,-10,-5,20], k = 2
//输出：23
//解释：子序列为 [10, -2, -5, 20] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 
// Related Topics 队列 数组 动态规划 滑动窗口 单调队列 堆（优先队列） 
// 👍 72 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: tomster
 * @data: 2021-07-24 22:54:49
 */
public class ConstrainedSubsequenceSum {
    public static void main(String[] args) {
        Solution solution = new ConstrainedSubsequenceSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int constrainedSubsetSum(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new ArrayDeque<>();
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && i - deque.peekFirst() > k) {
                    deque.pollFirst();
                }
                if (!deque.isEmpty()) {
                    nums[i] += Math.max(0, nums[deque.peekFirst()]);
                }
                result = Math.max(result, nums[i]);
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}