//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
// Related Topics 链表 
// 👍 115 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-04-17 23:13:53
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static void main(String[] args) {
        Solution solution = new RemoveZeroSumConsecutiveNodesFromLinkedList().new Solution();
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
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode node = dummy;
            int sum = 0;
            Map<Integer, ListNode> map = new HashMap<>();
            while (node != null) {
                sum += node.val;
                map.put(sum, node);
                node = node.next;
            }

            ListNode cur = dummy;
            sum = 0;
            while (cur != null) {
                cur.next = map.get(sum += cur.val).next;
                cur = cur.next;
            }

            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}