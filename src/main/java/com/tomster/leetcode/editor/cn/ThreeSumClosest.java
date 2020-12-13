//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 639 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2020-12-13 22:23:41
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }
            Arrays.sort(nums);
            int closet = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int low = i + 1;
                int high = nums.length - 1;
                int mTarget = target - nums[i];
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (Math.abs(sum - target) < Math.abs(closet - target)) {
                        closet = sum;
                    }
                    if (nums[low] + nums[high] > mTarget) {
                        high--;
                    } else if (nums[low] + nums[high] < mTarget) {
                        low++;
                    } else {
                        return target;
                    }
                }
            }
            return closet;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}