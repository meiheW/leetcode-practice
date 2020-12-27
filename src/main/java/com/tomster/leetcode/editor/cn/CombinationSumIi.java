//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 463 👎 0

package com.tomster.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2020-12-27 14:11:54
 */
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = solution.combinationSum2(candidates, 8);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backTrace(result, candidates, target, new ArrayList<Integer>(), 0);

            return result;
        }

        private void backTrace(List<List<Integer>> result, int[] candidates, int target, ArrayList<Integer> temp, int start) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            } else if (target > 0) {
                for (int i = start; i < candidates.length; i++) {
                    if (i > start && candidates[i - 1] == candidates[i]){
                        continue;
                    }
                    temp.add(candidates[i]);
                    backTrace(result, candidates, target - candidates[i], temp, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}