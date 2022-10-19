/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/
 * Related Topics 位运算 数组 👍 107 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 09:12:57
 */
public class WGki4K {
    public static void main(String[] args) {
        Solution solution = new WGki4K().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int total = 0;
                for (int num : nums) {
                    total += (num >> i) & 1;
                }
                if (total % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}