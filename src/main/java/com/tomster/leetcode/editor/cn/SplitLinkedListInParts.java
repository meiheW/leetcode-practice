//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。 
//
// 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。 
//
// 返回一个符合上述规则的链表的列表。 
//
// 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ] 
//
// 示例 1： 
//
// 
//输入: 
//root = [1, 2, 3], k = 5
//输出: [[1],[2],[3],[],[]]
//解释:
//输入输出各部分都应该是链表，而不是数组。
//例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.ne
//xt.next.next = null。
//第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
//最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
// 
//
// 示例 2： 
//
// 
//输入: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解释:
//输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示: 
//
// 
// root 的长度范围： [0, 1000]. 
// 输入的每个节点的大小范围：[0, 999]. 
// k 的取值范围： [1, 50]. 
// 
//
// 
// Related Topics 链表 
// 👍 124 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

/**
 * @author: tomster
 * @data: 2021-03-14 20:42:42
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
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
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] nodeList = new ListNode[k];
            if (root == null) {
                return nodeList;
            }
            //链表长度
            int len = 0;
            ListNode node = root;
            while (node != null) {
                len++;
                node = node.next;
            }
            int minLen = len / k;
            int addLen = len % k;

            ListNode head = root;
            int index = 0;
            while (head != null) {
                ListNode curHead = head;
                //移到当前段的最后一个节点
                int times = minLen + (addLen-- > 0 ? 1 : 0);
                while (--times > 0) {
                    head = head.next;
                }
                //记录下一个段的首节点，分隔
                ListNode nextHead = head.next;
                head.next = null;
                head = nextHead;
                nodeList[index++] = curHead;
            }
            return nodeList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}