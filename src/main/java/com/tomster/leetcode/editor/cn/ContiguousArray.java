//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 460 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-12 15:42:02
 */
public class ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：[1,0,1,0,1]
        //输出：4
        public int findMaxLength(int[] nums) {
            int counter = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(counter, -1);
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    counter++;
                } else {
                    counter--;
                }
                if (!map.containsKey(counter)) {
                    map.put(counter, i);
                } else {
                    int firstIndex = map.get(counter);
                    ans = Math.max(ans, i - firstIndex);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}