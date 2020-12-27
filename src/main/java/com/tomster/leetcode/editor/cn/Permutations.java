//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1053 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2020-12-27 15:02:37
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            backTrace(result, nums, new ArrayList<Integer>());
            return result;
        }

        private void backTrace(List<List<Integer>> result, int[] nums, ArrayList<Integer> temp) {
            if(nums.length==temp.size()){
                result.add(new ArrayList<>(temp));
            }else{
                for(int i=0; i<nums.length; i++){
                    if(temp.contains(nums[i])){
                        continue;
                    }
                    temp.add(nums[i]);
                    backTrace(result, nums, temp);
                    temp.remove(temp.size()-1);
                }


            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}