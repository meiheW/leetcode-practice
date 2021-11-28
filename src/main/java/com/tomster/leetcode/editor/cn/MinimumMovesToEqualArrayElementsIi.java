//给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。 
//
// 例如: 
//
// 
//输入:
//[1,2,3]
//
//输出:
//2
//
//说明：
//只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 
//
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
// Related Topics 数组 数学 排序 
// 👍 145 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-28 11:35:09
 */
public class MinimumMovesToEqualArrayElementsIi {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElementsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //移动次数+1/-1使元素相等 - 中位数
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int num : nums) {
                ans += Math.abs(nums[nums.length / 2] - num);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}