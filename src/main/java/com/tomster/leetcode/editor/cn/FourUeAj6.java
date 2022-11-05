/**
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * <p>
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整
 * 个列表如上图所示，最后返回节点 3 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [], insertVal = 1
 * 输出：[1]
 * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = [1], insertVal = 0
 * 输出：[1,0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-
 * circular-linked-list/
 * Related Topics 链表 👍 128 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.Node;

/**
 * @author: tomster
 * @data: 2022-11-05 21:41:12
 */
public class FourUeAj6 {
    public static void main(String[] args) {
        Solution solution = new FourUeAj6().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

    class Solution {
        public Node insert(Node head, int insertVal) {
            Node newNode = new Node(insertVal);
            if (head == null) {
                newNode.next = newNode;
                return newNode;
            }
            if (head.next == head) {
                head.next = newNode;
                newNode.next = head;
                return head;
            }
            Node cur = head, next = head.next;
            //循环推出点，next=head
            while (next != head) {
                if (insertVal >= cur.val && insertVal <= next.val) {
                    break;
                }
                if (cur.val > next.val) {
                    if (insertVal > cur.val || insertVal < next.val) {
                        break;
                    }
                }
                cur = cur.next;
                next = next.next;
            }
            cur.next = newNode;
            newNode.next = next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}