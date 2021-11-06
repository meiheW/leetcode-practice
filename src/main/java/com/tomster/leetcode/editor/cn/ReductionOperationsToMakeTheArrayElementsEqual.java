//给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤： 
//
// 
// 找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。 
// 找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。 
// 将 nums[i] 减少到 nextLargest 。 
// 
//
// 返回使 nums 中的所有元素相等的操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,1,3]
//输出：3
//解释：需要 3 次操作使 nums 中的所有元素相等：
//1. largest = 5 下标为 0 。nextLargest = 3 。将 nums[0] 减少到 3 。nums = [3,1,3] 。
//2. largest = 3 下标为 0 。nextLargest = 1 。将 nums[0] 减少到 1 。nums = [1,1,3] 。
//3. largest = 3 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1]
//输出：0
//解释：nums 中的所有元素已经是相等的。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,2,2,3]
//输出：4
//解释：需要 4 次操作使 nums 中的所有元素相等：
//1. largest = 3 下标为 4 。nextLargest = 2 。将 nums[4] 减少到 2 。nums = [1,1,2,2,2] 。
//2. largest = 2 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1,2,2] 。 
//3. largest = 2 下标为 3 。nextLargest = 1 。将 nums[3] 减少到 1 。nums = [1,1,1,1,2] 。 
//4. largest = 2 下标为 4 。nextLargest = 1 。将 nums[4] 减少到 1 。nums = [1,1,1,1,1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// 1 <= nums[i] <= 5 * 104 
// 
// Related Topics 数组 排序 
// 👍 9 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-11-06 22:05:41
 */
public class ReductionOperationsToMakeTheArrayElementsEqual {
    public static void main(String[] args) {
        Solution solution = new ReductionOperationsToMakeTheArrayElementsEqual().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        final int N = (int) Math.pow(10, 5);

        //计数排序 快！！！
        public int reductionOperations(int[] nums) {
            int[] arr = new int[N + 1];
            for (int num : nums) {
                arr[num]++;
            }
            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    numList.add(i);
                }
            }
            int ans = 0;
            for (int i = 1; i < numList.size(); i++) {
                ans += arr[numList.get(i)] * i;
            }
            return ans;
        }


        public int reductionOperations1(int[] nums) {
            Arrays.sort(nums);
            int cnt = 0;
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    cnt++;
                }
                ans += cnt;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}