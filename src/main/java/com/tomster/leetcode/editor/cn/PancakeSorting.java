//给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。 
//
// 一次煎饼翻转的执行过程如下： 
//
// 
// 选择一个整数 k ，1 <= k <= arr.length 
// 反转子数组 arr[0...k-1]（下标从 0 开始） 
// 
//
// 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。 
//
// 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断
//为正确。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,4,1]
//输出：[4,2,4,3]
//解释：
//我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
//初始状态 arr = [3, 2, 4, 1]
//第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
//第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
//第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
//第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。 
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3]
//输出：[]
//解释：
//输入已经排序，因此不需要翻转任何内容。
//请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= arr.length 
// arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列） 
// 
// Related Topics 贪心 数组 双指针 排序 
// 👍 128 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-11-28 15:01:15
 */
public class PancakeSorting {
    public static void main(String[] args) {
        Solution solution = new PancakeSorting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            int n = arr.length;
            List<Integer> ans = new ArrayList<>();
            for (int target = n; target >= 2; target--) {
                int maxIndex = findMax(arr, target);
                reverse(arr, maxIndex);
                reverse(arr, target - 1);
                ans.add(maxIndex + 1);
                ans.add(target);
            }
            return ans;
        }

        private void reverse(int[] arr, int maxIndex) {
            int low = 0;
            int high = maxIndex;
            while (low < high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        private void swap(int[] arr, int low, int high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        private int findMax(int[] arr, int n) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == n) {
                    return i;
                }
            }
            return -1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}