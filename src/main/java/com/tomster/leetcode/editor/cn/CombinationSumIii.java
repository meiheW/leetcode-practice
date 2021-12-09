//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 
// 👍 397 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-12-09 22:21:10
 */
public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //找出所有相加之和为n的k个数的组合, n,k均为正整数
        //组合中只允许含有1-9的正整数,并且每种组合中不存在重复的数字
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            backTracing(ans, new ArrayList<>(), k, n, nums, 0);
            return ans;
        }

        private void backTracing(List<List<Integer>> ans, List<Integer> temp, int k, int target, int[] nums, int start) {
            if (temp.size() == k && target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            //剪枝:后面数量加起来不足k个
            if (target < 0) {
                return;
            }
            if (temp.size() + (nums.length - start + 1) < k) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backTracing(ans, temp, k, target - nums[i], nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}