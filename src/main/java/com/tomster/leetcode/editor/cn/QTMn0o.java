/**
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -1000 <= nums[i] <= 1000
 * <p>
 * -10⁷ <= k <= 10⁷
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * Related Topics 数组 哈希表 前缀和 👍 111 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2022-10-19 14:05:19
 */
public class QTMn0o {
    public static void main(String[] args) {
        Solution solution = new QTMn0o().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> preSumMap = new HashMap<>();
            int preSum = 0;
            preSumMap.put(0, 1);

            int ans = 0;
            for (int num : nums) {
                preSum += num;
                ans += preSumMap.getOrDefault(preSum - k, 0);
                preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}