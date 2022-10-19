/**
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10⁶
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * <p>
 * Related Topics 数组 滑动窗口 👍 109 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 13:35:55
 */
public class ZVAVXX {
    public static void main(String[] args) {
        Solution solution = new ZVAVXX().new Solution();
        int i = solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int product = 1;
            int p1 = 0;
            int ans = 0;
            for (int p2 = 0; p2 < nums.length; p2++) {
                product *= nums[p2];
                while (p2 >= p1 && product >= k) {
                    product /= nums[p1++];
                }
                ans += p2 - p1 + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}