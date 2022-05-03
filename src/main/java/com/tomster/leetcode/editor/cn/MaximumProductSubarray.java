//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
// Related Topics 数组 动态规划 
// 👍 1566 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2022-03-23 15:47:48
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入: nums = [2,3,-2,4]
        //输出: 6
        //解释: 子数组 [2,3] 有最大乘积6
        public int maxProduct(int[] nums) {
            int n = nums.length;
            //max[i],min[i]表示以nums[i]为结尾的子数组乘积的最大值和最小值
            int[] max = new int[n];
            int[] min = new int[n];
            System.arraycopy(nums, 0, max, 0, n);
            System.arraycopy(nums, 0, min, 0, n);
            for (int i = 1; i < n; i++) {
                max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
                min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            }
            return Arrays.stream(max).max().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}