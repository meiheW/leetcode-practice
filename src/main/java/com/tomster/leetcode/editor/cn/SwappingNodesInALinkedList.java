//给你链表的头节点 head 和一个整数 k 。 
//
// 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
//输出：[7,9,6,6,8,7,3,0,9,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：head = [1,2], k = 1
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：head = [1,2,3], k = 2
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目是 n 
// 1 <= k <= n <= 105 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 13 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

/**
 * @author: tomster
 * @data: 2021-03-21 12:30:37
 */
public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        Solution solution = new SwappingNodesInALinkedList().new Solution();
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
        public ListNode swapNodes(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            int k1 = k;
            ListNode p1 = head;
            while (--k1 > 0) {
                p1 = p1.next;
            }
            ListNode first = p1;

            ListNode p2 = head;
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            int temp = p2.val;
            p2.val = first.val;
            first.val = temp;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}