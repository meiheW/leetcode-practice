//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 550 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2020-12-27 15:03:10
 */
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //这类问题，如果有重复数据一定要排序一下，即使不重复没有必要的时候也可以用来做剪枝操作
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            backTrace(result, nums, new ArrayList<Integer>(), used);
            return result;
        }

        private void backTrace(List<List<Integer>> result, int[] nums, ArrayList<Integer> temp, boolean[] used) {
            if (nums.length == temp.size()) {
                result.add(new ArrayList<>(temp));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    //过滤掉不满足条件的分支，理解一下这个条件，两种情况：
                    //情况一：数组中下标为i的元素已经用过了，就不要在用了
                    //情况二：数组中下标i和i-1值相同，但是i-1没有用，那后面相同的都不能用
                    //       这是因为原数组中包括相同的元素，如果不将这些排除，结果集中将因此包含很多重复集合
                    if (used[i] || i>0 && nums[i-1]==nums[i] && !used[i-1]) {
                        continue;
                    }
                    temp.add(nums[i]);
                    used[i] = true;
                    backTrace(result, nums, temp, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }


            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}