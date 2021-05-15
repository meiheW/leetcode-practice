//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 541 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2021-03-22 18:45:57
 */
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
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
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            LinkedList<ListNode> deque = new LinkedList<>();
            ListNode cur = head;
            while (cur != null) {
                deque.addLast(cur);
                cur = cur.next;
            }
            boolean firstPoll = true;
            ListNode pilot = new ListNode(0);
            ListNode pre = pilot;
            while (!deque.isEmpty()) {
                ListNode curPoll = firstPoll ? deque.pollFirst() : deque.pollLast();
                curPoll.next = null;
                pre.next = curPoll;
                pre = curPoll;
                firstPoll = !firstPoll;

            }

        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}