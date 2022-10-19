/**
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * <p>
 * 示例2：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * <p>
 * <p>
 * 示例3：
 * <p>
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/
 * Related Topics 栈 链表 数学 👍 69 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2022-10-19 16:14:15
 */
public class LMSNwu {
    public static void main(String[] args) {
        Solution solution = new LMSNwu().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            LinkedList<Integer> deque1 = new LinkedList<>();
            LinkedList<Integer> deque2 = new LinkedList<>();
            while (l1 != null) {
                deque1.addFirst(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                deque2.addFirst(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            int index1 = 0, index2 = 0;
            ListNode next = null, cur = null;
            while (index1 < deque1.size() || index2 < deque2.size() || carry != 0) {
                int sum = carry +
                        (index1 == deque1.size() ? 0 : deque1.get(index1++)) +
                        (index2 == deque2.size() ? 0 : deque2.get(index2++));

                carry = sum / 10;
                cur = new ListNode(sum % 10);
                cur.next = next;
                next = cur;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}