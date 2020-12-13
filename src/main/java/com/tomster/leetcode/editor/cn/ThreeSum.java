//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2813 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2020-12-13 21:56:20
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                //排序后的第一个数如果和前一个相同，则直接跳过
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                //第一个数字大于0，直接跳出后面
                if(nums[i]>0){
                    break;
                }

                int low = i + 1;
                int high = nums.length - 1;
                int target = -nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] > target) {
                        high--;
                    } else if (nums[low] + nums[high] < target) {
                        low++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        //如果low和high对应的值正好满足要求，则形成一个结果，但是两个指针的位置需要调整
                        //low要移到后面第一个不等于自生的地方，同理，high也是一样，始终保持low<high
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }


                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}