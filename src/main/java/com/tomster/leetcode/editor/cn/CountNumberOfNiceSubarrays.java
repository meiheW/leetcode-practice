//给你一个整数数组 nums 和一个整数 k。 
//
// 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。 
//
// 请返回这个数组中「优美子数组」的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
// 
//
// 示例 3： 
//
// 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 数组 哈希表 数学 滑动窗口 
// 👍 185 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-09-25 19:00:44
 */
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfNiceSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int n = nums.length;
            List<Integer> oddIndex = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (nums[i] % 2 == 1) {
                    oddIndex.add(i);
                }
            }
            int ans = 0;
            for (int i = 0; i <= oddIndex.size() - k; i++) {
                int start = oddIndex.get(i);
                int end = oddIndex.get(i + k - 1);
                int lastStart = i == 0 ? -1 : oddIndex.get(i - 1);
                int nextEnd = (i == oddIndex.size() - k) ? n : oddIndex.get(i + k);
                ans += (start - lastStart) * (nextEnd - end);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}