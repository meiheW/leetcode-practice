//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1075 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author: tomster
 * @data: 2021-07-17 22:00:40
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = solution.maxSlidingWindow(arr, 3);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] result = new int[n - k + 1];
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int left = 0, right = k - 1;
            for (int i = left; i <= right; i++) {
                treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            }
            int index = 0;
            while (right++ < n) {
                result[index++] = treeMap.lastKey();
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
                if (right < n) {
                    treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
                }
            }
            return result;
        }

        //1.切勿对非堆顶元素进行直接删除
        public int[] maxSlidingWindow1(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            int left = 0, right = k - 1;
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = left; i <= right; i++) {
                heap.offer(nums[i]);
            }
            int index = 0;
            while (right < nums.length) {
                result[index++] = heap.peek();
                heap.remove(nums[left]);
                ++left;
                if (++right < nums.length) {
                    heap.offer(nums[right]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}