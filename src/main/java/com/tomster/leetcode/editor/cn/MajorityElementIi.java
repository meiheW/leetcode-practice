//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
// Related Topics 数组 哈希表 计数 排序 
// 👍 527 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-11-28 10:44:45
 */
public class MajorityElementIi {
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //摩尔投票法
        public List<Integer> majorityElement(int[] nums) {
            int candidate1 = 0, vote1 = 0;
            int candidate2 = 0, vote2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && candidate1 == num) {
                    vote1++;
                } else if (vote2 > 0 && candidate2 == num) {
                    vote2++;
                } else if (vote1 == 0) {
                    candidate1 = num;
                    vote1 = 1;
                } else if (vote2 == 0) {
                    candidate2 = num;
                    vote2 = 1;
                } else {
                    vote1--;
                    vote2--;
                }
            }
            //统计candidate的出现次数
            int num1 = 0, num2 = 0;
            for (int num : nums) {
                if (num == candidate1) {
                    num1++;
                } else if (num == candidate2) {
                    num2++;
                }
            }

            List<Integer> ans = new ArrayList<>();
            if (num1 > nums.length / 3) {
                ans.add(candidate1);
            }
            if (num2 > nums.length / 3) {
                ans.add(candidate2);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}