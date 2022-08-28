/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数
 * 组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁴
 * 1 <= x <= 10⁹
 * <p>
 * Related Topics 数组 哈希表 二分查找 前缀和 滑动窗口 👍 116 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2022-08-28 14:26:10
 */
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //数组两端某些元素之和为x,记数组总和为sum
        //求最小的数目使两端和为x,即求和为sum-x的最长的子数组长度
        public int minOperations(int[] nums, int x) {
            //前缀和
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            int target = preSum[n] - x;
            if (target < 0) {
                return -1;
            } else if (target == 0) {
                return n;
            }
            Map<Integer, Integer> sumMap = new HashMap<>();
            int ans = -1;
            for (int i = 0; i < n + 1; i++) {
                if (sumMap.containsKey(preSum[i] - target)) {
                    ans = Math.max(ans, i - sumMap.get(preSum[i] - target));
                }
                sumMap.put(preSum[i], i);
            }
            return ans == -1 ? -1 : n - ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}