/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * Related Topics 链表 双指针 👍 394 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

/**
 * @author: tomster
 * @data: 2022-09-09 12:37:04
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
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
        public ListNode getKthFromEnd(ListNode head, int k) {
            //求链表长度
            ListNode cur = head;
            int len = 0;
            while (cur != null) {
                cur = cur.next;
                len++;
            }
            if (k <= 0 || k > len) {
                return null;
            }
            //双指针，快的先走k
            ListNode p1 = head, p2 = head;
            while (k-- > 0) {
                p2 = p2.next;
            }
            while (p2 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            return p1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}