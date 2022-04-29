//给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 104 
// 数组里的每个元素与 x 的绝对值不超过 104 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 
// 👍 235 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: tomster
 * @data: 2021-07-26 17:23:01
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
        List<Integer> closestElements = solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        System.out.println(closestElements);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //二分
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ans = new ArrayList<>();
            int n = arr.length;
            int index = Arrays.binarySearch(arr, x);
            if (index < 0) {
                index = -(1 + index);
            }
            int low = index - 1;
            int high = index;
            int kk = k;
            while (kk-- > 0) {
                if (low == -1) {
                    high = k;
                    break;
                } else if (high == arr.length) {
                    low = n - k - 1;
                    break;
                } else {
                    if (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x)) {
                        low--;
                    } else {
                        high++;
                    }
                }
            }
            for (int i = low + 1; i < high; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }


        //堆
        public List<Integer> findClosestElements1(int[] arr, int k, int x) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - x) != Math.abs(o2 - x) ?
                    Integer.compare(Math.abs(o2 - x), Math.abs(o1 - x)) :
                    Integer.compare(o2, o1));

            for (int i : arr) {
                pq.offer(i);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            List<Integer> ans = new ArrayList<>();
            while (!pq.isEmpty()) {
                ans.add(pq.poll());
            }
            return ans.stream().sorted().collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}