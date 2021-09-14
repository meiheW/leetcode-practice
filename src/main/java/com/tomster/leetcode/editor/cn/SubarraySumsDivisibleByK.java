//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 304 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 20:21:58
 */
public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumsDivisibleByK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int preSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int ans = 0;
            for (int num : nums) {
                preSum += num;
                int remainder = preSum % k;
                if (remainder < 0) {
                    remainder = k + remainder;
                }
                int count = map.getOrDefault(remainder, 0);
                ans += count;
                map.put(remainder, count + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}