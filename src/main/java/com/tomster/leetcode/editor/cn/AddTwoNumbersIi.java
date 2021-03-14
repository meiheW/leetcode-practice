//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 353 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2021-03-14 14:12:25
 */
public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            LinkedList<Integer> deque1 = new LinkedList<>();
            LinkedList<Integer> deque2 = new LinkedList<>();
            while (l1 != null) {
                deque1.addLast(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                deque2.addLast(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode result = null;
            while (!deque1.isEmpty() || !deque2.isEmpty() || carry != 0) {
                int num1 = deque1.isEmpty() ? 0 : deque1.pollLast();
                int num2 = deque2.isEmpty() ? 0 : deque2.pollLast();
                int sum = carry + num1 + num2;
                carry = sum / 10;
                ListNode node = new ListNode(sum % 10);
                node.next = result;
                result = node;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}