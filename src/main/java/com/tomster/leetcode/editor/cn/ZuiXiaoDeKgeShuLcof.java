/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 481 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2022-09-12 13:05:17
 */
public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        int[] res = solution.getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8);
        System.out.println("hello");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k <= 0) {
                return new int[]{};
            }
            //最大堆
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j : arr) {
                if (pq.size() < k || pq.peek() >= j) {
                    pq.add(j);
                }
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            int[] ans = new int[k];
            int p = 0;
            for (Integer item : pq) {
                ans[p++] = item;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}