//给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。 
//
// 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始
//）。 
//
// 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。 
//
// 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。 
//
// |x| 定义为： 
//
// 
// 如果 x >= 0 ，值为 x ，或者 
// 如果 x <= 0 ，值为 -x 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,7,5], nums2 = [2,3,5]
//输出：3
//解释：有两种可能的最优方案：
//- 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
//- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
//两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
//输出：0
//解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
//输出：20
//解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
//绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// 1 <= n <= 105 
// 1 <= nums1[i], nums2[i] <= 105 
// 
// Related Topics 数组 二分查找 有序集合 排序 
// 👍 127 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2022-05-13 16:30:16
 */
public class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteSumDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int MOD = 1_000_000_007;
            int n = nums1.length;
            int[] arr = new int[n];
            System.arraycopy(nums1, 0, arr, 0, n);
            Arrays.sort(arr);
            int sum = 0, max = 0;
            for (int i = 0; i < n; i++) {
                int diff = Math.abs(nums1[i] - nums2[i]);
                sum = (sum + diff) % MOD;
                int j = binarySearch(arr, nums2[i]);
                if (j < n) {
                    max = Math.max(max, diff - (arr[j] - nums2[i]));
                }
                if (j > 0) {
                    max = Math.max(max, diff - (nums2[i] - arr[j - 1]));
                }
            }
            return (sum - max + MOD) % MOD;
        }

        public int binarySearch(int[] rec, int target) {
            int low = 0, high = rec.length - 1;
            if (rec[high] < target) {
                return high + 1;
            }
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (rec[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}