//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和
//最接近 target （最接近表示两者之差的绝对值最小）。 
//
// 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。 
//
// 请注意，答案不一定是 arr 中的数字。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,9,3], target = 10
//输出：3
//解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
// 
//
// 示例 2： 
//
// 输入：arr = [2,3,5], target = 10
//输出：5
// 
//
// 示例 3： 
//
// 输入：arr = [60864,25176,27249,21296,20204], target = 56803
//输出：11361
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i], target <= 10^5 
// 
// Related Topics 数组 二分查找 排序 
// 👍 165 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2022-05-14 14:32:05
 */
public class SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        Solution solution = new SumOfMutatedArrayClosestToTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：arr = [4,9,3], target = 10
        //输出：3
        //解释：当选择value为3时，数组会变成[3,3,3]，和为9
        public int findBestValue(int[] arr, int target) {
            Arrays.sort(arr);
            int n = arr.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + arr[i];
            }
            int diff = target;
            int ans = 0;
            for (int i = 1; i <= arr[n - 1]; i++) {
                int index = Arrays.binarySearch(arr, i);
                if (index < 0) {
                    index = -(1 + index);
                }
                int curSum = preSum[index] + (n - index) * i;
                int curDiff = Math.abs(curSum - target);
                if (curDiff < diff) {
                    diff = curDiff;
                    ans = i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}