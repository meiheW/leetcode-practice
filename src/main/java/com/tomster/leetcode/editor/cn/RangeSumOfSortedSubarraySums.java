//给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数
//字的数组。 
//
// 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模
//后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
//输出：13 
//解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5
//, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
//输出：6
//解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和
//为 3 + 3 = 6 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
//输出：50
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^3 
// nums.length == n 
// 1 <= nums[i] <= 100 
// 1 <= left <= right <= n * (n + 1) / 2 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 32 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-12-05 13:54:26
 */
public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        Solution solution = new RangeSumOfSortedSubarraySums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {
            int[] arr = new int[n * (n + 1) / 2];
            int index = 0;
            for (int i = 0; i < n; i++) {
                int sum = nums[i];
                arr[index++] = sum;
                for (int j = i + 1; j < n; j++) {
                    sum += nums[j];
                    arr[index++] = sum;
                }
            }
            Arrays.sort(arr);
            int ans = 0;
            for (int i = left; i <= right; i++) {
                ans += arr[i - 1];
                ans %= 1_000_000_007;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}