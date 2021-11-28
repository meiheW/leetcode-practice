//给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两
//侧相邻元素的 平均值 。 
//
// 更公式化的说法是，重新排列的数组应当满足这一属性：对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + n
//ums[i+1]) / 2 不等于 nums[i] 均成立 。 
//
// 返回满足题意的任一重排结果。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,4,5]
//输出：[1,2,4,5,3]
//解释：
//i=1, nums[i] = 2, 两相邻元素平均值为 (1+4) / 2 = 2.5
//i=2, nums[i] = 4, 两相邻元素平均值为 (2+5) / 2 = 3.5
//i=3, nums[i] = 5, 两相邻元素平均值为 (4+3) / 2 = 3.5
// 
//
// 示例 2： 
//
// 输入：nums = [6,2,0,9,7]
//输出：[9,7,6,2,0]
//解释：
//i=1, nums[i] = 7, 两相邻元素平均值为 (9+6) / 2 = 7.5
//i=2, nums[i] = 6, 两相邻元素平均值为 (7+2) / 2 = 4.5
//i=3, nums[i] = 2, 两相邻元素平均值为 (6+0) / 2 = 3
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 105 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 排序 
// 👍 11 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-28 15:51:09
 */
public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    public static void main(String[] args) {
        Solution solution = new ArrayWithElementsNotEqualToAverageOfNeighbors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeArray(int[] nums) {
            Arrays.sort(nums);
            int[] ans = new int[nums.length];

            int index = 0;
            for (int i = 0; i < nums.length; i += 2) {
                ans[i] = nums[index++];
            }
            for (int i = 1; i < nums.length; i += 2) {
                ans[i] = nums[index++];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}