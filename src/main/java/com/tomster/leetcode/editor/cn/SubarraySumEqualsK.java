//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 1094 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-12 18:03:51
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            int preSum = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            countMap.put(0, 1);
            for (int num : nums) {
                preSum += num;
                int target = preSum - k;
                if (countMap.containsKey(target)) {
                    ans += countMap.get(target);
                }
                countMap.put(preSum, countMap.getOrDefault(preSum, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}