//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 445 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2021-07-26 17:56:34
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minQueue = new PriorityQueue<>(Comparator.naturalOrder());
            maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            if (maxQueue.isEmpty()) {
                maxQueue.offer(num);
                return;
            }
            //存队列
            if (num <= maxQueue.peek()) {
                maxQueue.offer(num);
            } else {
                minQueue.offer(num);
            }
            //调整两个队列的大小
            if (maxQueue.size() > minQueue.size() + 1) {
                minQueue.offer(maxQueue.poll());
            }
            if (maxQueue.size() < minQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }
        }

        public double findMedian() {
            return maxQueue.size() == minQueue.size()
                    ? (maxQueue.peek() + minQueue.peek()) * 0.5
                    : maxQueue.peek();
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