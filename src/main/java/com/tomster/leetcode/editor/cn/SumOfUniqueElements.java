//给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。 
//
// 请你返回 nums 中唯一元素的 和 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,2]
//输出：4
//解释：唯一元素为 [1,3] ，和为 4 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1,1]
//输出：0
//解释：没有唯一元素，和为 0 。
// 
//
// 示例 3 ： 
//
// 输入：nums = [1,2,3,4,5]
//输出：15
//解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
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
// Related Topics 数组 哈希表 计数 
// 👍 9 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 22:34:25
 */
public class SumOfUniqueElements {
    public static void main(String[] args) {
        Solution solution = new SumOfUniqueElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfUnique(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                Integer count = map.getOrDefault(num, 0);
                map.put(num, count + 1);
            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    ans += entry.getKey();
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}