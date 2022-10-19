/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 不是 0 就是 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/
 * Related Topics 数组 哈希表 前缀和 👍 104 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2022-10-19 14:12:08
 */
public class A1NYOS {
    public static void main(String[] args) {
        Solution solution = new A1NYOS().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int cnt = 0, ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    cnt--;
                } else {
                    cnt++;
                }
                if (map.containsKey(cnt)) {
                    ans = Math.max(ans, i - map.get(cnt));
                } else {
                    map.put(cnt, i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}