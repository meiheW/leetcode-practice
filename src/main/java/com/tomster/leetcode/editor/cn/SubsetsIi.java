//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 360 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2020-12-27 15:18:16
 */
public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //第一遍没有成功，eg 4,4,4,1,4,没有排序的原因
            Arrays.sort(nums);
            backTrace(result, nums, new ArrayList<Integer>(), 0);
            return result;
        }

        private void backTrace(List<List<Integer>> result, int[] nums, ArrayList<Integer> temp, int start) {
            result.add(new ArrayList<>(temp));
            for (int i = start; i < nums.length; i++) {
                //排重
                if (i > start && nums[i - 1] == nums[i]) {
                    continue;
                }
                temp.add(nums[i]);
                backTrace(result, nums, temp, i+1);
                temp.remove(temp.size() - 1);

            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}