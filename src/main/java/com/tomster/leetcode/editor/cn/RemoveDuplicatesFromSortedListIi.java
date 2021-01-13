//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 428 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

/**
 * @author: tomster
 * @data: 2021-01-13 23:49:23
 */
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //添加哨兵
            ListNode pilot = new ListNode(1);
            pilot.next = head;

            ListNode pre = pilot;
            ListNode cur = head;

            while (cur != null) {
                if (cur.next == null || cur.next.val != cur.val) {
                    pre = cur;
                    cur = cur.next;
                } else {
                    while (cur.next != null && cur.next.val == cur.val) {
                        cur = cur.next;
                    }
                    pre.next = cur.next;
                    cur = cur.next;//cur指向下一个不同的节点或null结点
                }
            }
            return pilot.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}