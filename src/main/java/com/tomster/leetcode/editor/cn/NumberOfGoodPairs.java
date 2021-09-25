//给你一个整数数组 nums 。 
//
// 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。 
//
// 返回好数对的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,1,1,3]
//输出：4
//解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
// 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1]
//输出：6
//解释：数组中的每组数字都是好数对 
//
// 示例 3： 
//
// 输入：nums = [1,2,3]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 数学 计数 
// 👍 71 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 22:06:49
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfGoodPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 求有序数组中连续相等数字的数目
         * 数组中相等数字的数目
         */
        public int numIdenticalPairs(int[] nums) {
            Arrays.sort(nums);
            int p0 = 0;
            int p1 = 0;
            int span = 0;
            int ans = 0;
            while (p1 < nums.length) {
                if (nums[p1] == nums[p0]) {
                    span++;
                } else {
                    ans += span * (span - 1) / 2;
                    span = 1;
                    p0 = p1;
                }
                p1++;
            }
            ans += span * (span - 1) / 2;
            return ans;
        }

        public int numIdenticalPairs1(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int ans = 0;
            for (Integer v : map.values()) {
                ans += v * (v - 1) / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}