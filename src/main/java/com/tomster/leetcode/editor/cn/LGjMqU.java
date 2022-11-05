/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表的长度范围为 [1, 5 * 10⁴]
 * 1 <= node.val <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/
 * Related Topics 栈 递归 链表 双指针 👍 79 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-11-05 20:21:29
 */
public class LGjMqU {
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
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
            if (head == null) {
                return;
            }
            List<ListNode> nodeList = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                nodeList.add(cur);
                cur = cur.next;
            }
            int i = 0, j = nodeList.size() - 1;
            while (i < j) {
                nodeList.get(i).next = nodeList.get(j);
                i++;
                if (i == j) {
                    break;
                }
                nodeList.get(j).next = nodeList.get(i);
                j--;
            }
            nodeList.get(i).next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}