/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 * Related Topics 递归 链表 👍 481 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

/**
 * @author: tomster
 * @data: 2022-09-09 12:44:54
 */
public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
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
        //递归方法
        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            ListNode newHead = reverseList(next);
            next.next = head;
            head.next = null;//这一步不能忘了，不然链表内部就循环了
            return newHead;
        }


        //非递归方法
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}