/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length。
 * <p>
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 * Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 508 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2022-10-14 19:15:19
 */
public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1.单调队列
        public int[] maxSlidingWindow1(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            ans[0] = nums[deque.peekFirst()];
            for (int i = k; i < n; i++) {
                //单调递减
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                //这一步很重要，区间外的剔除掉
                while (i - deque.peekFirst() >= k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;
        }


        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (o1, o2) -> Integer.compare(nums[o2], nums[o1]));
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            for (int i = 0; i < k; i++) {
                pq.offer(i);
            }
            ans[0] = nums[pq.peek()];
            for (int i = k; i < n; i++) {
                pq.offer(i);
                while (pq.peek() <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = nums[pq.peek()];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}