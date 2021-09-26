//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。 
//
// 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。 
//
// 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//输出：-1
//解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
// 
//
// 示例 3： 
//
// 输入：nums1 = [6,6], nums2 = [1]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 105 
// 1 <= nums1[i], nums2[i] <= 6 
// 
// Related Topics 贪心 数组 哈希表 计数 
// 👍 40 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-09-26 23:33:51
 */
public class EqualSumArraysWithMinimumNumberOfOperations {
    public static void main(String[] args) {
        Solution solution = new EqualSumArraysWithMinimumNumberOfOperations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int sum1 = arrSum(nums1);
            int sum2 = arrSum(nums2);
            int diff = Math.abs(sum1 - sum2);
            if (diff == 0) {
                return 0;
            }
            //保证countArr1总和大于countArr2，方便计算
            int[] countArr1 = sum2 > sum1 ? countArr(nums2) : countArr(nums1);
            int[] countArr2 = sum2 > sum1 ? countArr(nums1) : countArr(nums2);
            int ans = 0;
            for (int i = 0; i < 5; i++) {
                int count = countArr1[6 - 1 - i] + countArr2[i];
                int factor = 6 - 1 - i;
                if (count * factor < diff) {
                    diff -= count * factor;
                    ans += count;
                } else {
                    return ans + (diff - 1) / factor + 1;
                }
            }
            return diff > 0 ? -1 : ans;
        }

        private int[] countArr(int[] nums) {
            int[] arr = new int[6];
            for (int num : nums) {
                arr[num - 1]++;
            }
            return arr;
        }

        private int arrSum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}