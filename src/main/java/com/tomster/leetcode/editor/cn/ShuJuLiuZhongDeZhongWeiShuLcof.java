/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排
 * 序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 * <p>
 * <p>
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 * <p>
 * Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 362 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2022-09-10 09:27:58
 */
public class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        //Solution solution = new ShuJuLiuZhongDeZhongWeiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            //存队列
            if (minQueue.isEmpty() || minQueue.peek() <= num) {
                minQueue.add(num);
            } else {
                maxQueue.add(num);
            }
            //保证minQ大小>=maxQ，且最多大1
            if (maxQueue.size() > minQueue.size()) {
                minQueue.add(maxQueue.poll());
            }
            if (maxQueue.size() + 1 < minQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
        }

        public double findMedian() {
            return maxQueue.size() == minQueue.size() ?
                    (maxQueue.peek() + minQueue.peek()) * 1.0 / 2
                    : minQueue.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}