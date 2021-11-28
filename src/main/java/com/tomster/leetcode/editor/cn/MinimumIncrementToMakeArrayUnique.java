//给你一个整数数组 nums 。每次 move 操作将会选择任意一个满足 0 <= i < nums.length 的下标 i，并将 nums[i] 递增 1
//。 
//
// 返回使 nums 中的每个值都变成唯一的所需要的最少操作次数。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：1
//解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,2,1,7]
//输出：6
//解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
//可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。 
// 
// 
//
// 
//提示：
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 计数 排序 
// 👍 191 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-11-28 14:46:36
 */
public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        Solution solution = new MinimumIncrementToMakeArrayUnique().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minIncrementForUnique(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] >= nums[i]) {
                    int curNew = nums[i - 1] + 1;
                    ans += curNew - nums[i];
                    nums[i] = curNew;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}