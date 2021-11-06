//给你一个整数数组 nums 和一个整数 k 。 
//
// 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。 
//
// 返回你可以对数组执行的最大操作数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], k = 5
//输出：2
//解释：开始时 nums = [1,2,3,4]：
//- 移出 1 和 4 ，之后 nums = [2,3]
//- 移出 2 和 3 ，之后 nums = []
//不再有和为 5 的数对，因此最多执行 2 次操作。 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,3], k = 6
//输出：1
//解释：开始时 nums = [3,1,3,4,3]：
//- 移出前两个 3 ，之后nums = [1,4,3]
//不再有和为 6 的数对，因此最多执行 1 次操作。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 109 
// 1 <= k <= 109 
// 
// Related Topics 数组 哈希表 双指针 排序 
// 👍 19 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-06 21:41:08
 */
public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        Solution solution = new MaxNumberOfKSumPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxOperations(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            Arrays.sort(nums);
            int low = 0, high = n - 1;
            int ans = 0;
            while (low < high) {
                if (nums[low] + nums[high] > k) {
                    high--;
                } else if (nums[low] + nums[high] < k) {
                    low++;
                } else {
                    low++;
                    high--;
                    ans++;
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}