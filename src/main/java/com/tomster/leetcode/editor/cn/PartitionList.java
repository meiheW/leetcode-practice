//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 354 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-15 22:40:30
 */
public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = head;
            ListNode lessPilot = new ListNode(0);
            ListNode lessNode = lessPilot;
            ListNode morePilot = new ListNode(0);
            ListNode moreNode = morePilot;

            while (node != null) {
                if (node.val < x) {
                    lessNode.next = node;
                    lessNode = lessNode.next;
                } else {
                    moreNode.next = node;
                    moreNode = moreNode.next;
                }
                node = node.next;
            }
            //lessNode.next = null;
            //这一步非常重要，不然会循环；如果不想这么复杂，可以new 链表节点
            moreNode.next = null;
            lessNode.next = morePilot.next;
            return lessPilot.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}