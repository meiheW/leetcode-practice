//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1094 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-08-14 23:03:42
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 超级水王
         */
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int candidate = Integer.MIN_VALUE;
            int hp = 0;
            for (int num : nums) {
                if (hp == 0) {
                    candidate = num;
                    hp = 1;
                } else if (num == candidate) {
                    hp++;
                } else {
                    hp--;
                }
            }
            return candidate;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}