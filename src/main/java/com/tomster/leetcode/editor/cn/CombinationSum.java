//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1102 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2020-12-27 14:11:44
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backTrace(result, candidates, target, new ArrayList<Integer>(), 0);
            return result;
        }

        private void backTrace(List<List<Integer>> result, int[] candidates, int target, ArrayList<Integer> temp, int start) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            } else if (target > 0) {
                //尝试着去理解为什么不是从0开始，会有重复，每个数算过后，都往后加。
                for (int i = start; i < candidates.length; i++) {
                    if(target - candidates[i]<0){//剪枝操作
                        break;
                    }
                    temp.add(candidates[i]);
                    backTrace(result, candidates, target - candidates[i], temp, i);
                    temp.remove(temp.size() - 1);
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}