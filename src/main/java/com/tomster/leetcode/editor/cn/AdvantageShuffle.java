//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心 数组 排序 
// 👍 158 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2021-11-28 20:43:33
 */
public class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            int[] ans = new int[nums1.length];
            //nums2建立最大堆
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
            for (int i = 0; i < nums2.length; i++) {
                pq.offer(new int[]{nums2[i], i});
            }
            int low = 0, high = nums1.length - 1;
            while (!pq.isEmpty()) {
                int[] peek = pq.poll();
                int val = peek[0], index = peek[1];
                //nums1当前最大值与nums2堆顶元素比较
                if (nums1[high] > val) {
                    ans[index] = nums1[high--];
                } else {
                    ans[index] = nums1[low++];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}