//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 211 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 19:01:48
 */
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new BinarySubarraysWithSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            //记录前缀和出现的频次
            Map<Integer, Integer> preCountMap = new HashMap<>();
            preCountMap.put(0, 1);
            int ans = 0;
            int preSum = 0;
            for (int num : nums) {
                preSum += num;
                if (preCountMap.containsKey(preSum - goal)) {
                    ans += preCountMap.get(preSum - goal);
                }
                preCountMap.put(preSum, preCountMap.getOrDefault(preSum, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}