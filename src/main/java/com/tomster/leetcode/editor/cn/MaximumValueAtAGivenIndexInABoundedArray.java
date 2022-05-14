//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）： 
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//
// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 109 
// 0 <= index < n 
// 
// Related Topics 贪心 二分查找 
// 👍 36 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-05-14 17:05:00
 */
public class MaximumValueAtAGivenIndexInABoundedArray {
    public static void main(String[] args) {
        Solution solution = new MaximumValueAtAGivenIndexInABoundedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int low = 1, high = maxSum;
            int ans = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                long sum = getMinSum(n, index, mid);
                if (sum <= maxSum) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;

        }

        private long getMinSum(int n, int index, long max) {
            int left = index, right = n - 1 - index;
            long sum = 0;
            if (left <= max - 1) {
                sum += (2 * max - left) * (left + 1) / 2;
            } else {
                sum += (1 + max) * max / 2 + (left - max + 1);
            }
            if (right <= max - 1) {
                sum += (2 * max - right) * (right + 1) / 2;
            } else {
                sum += (1 + max) * max / 2 + (right - max + 1);
            }
            sum -= max;
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}