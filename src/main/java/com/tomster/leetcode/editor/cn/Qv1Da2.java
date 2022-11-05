/**
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多
 * 级数据结构，如下面的示例所示。
 * <p>
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * <p>
 * <p>
 * 扁平化后的链表如下图：
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * 1---2---NULL
 * |
 * 3---NULL
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 如何表示测试用例中的多级链表？
 * <p>
 * 以 示例 1 为例：
 * <p>
 * <p>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * <p>
 * 序列化其中的每一级之后：
 * <p>
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * <p>
 * <p>
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * <p>
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * <p>
 * <p>
 * 合并所有序列化结果，并去除末尾的 null 。
 * <p>
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 430 题相同： https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-
 * linked-list/
 * Related Topics 深度优先搜索 链表 双向链表 👍 52 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.flatten.Node;

/**
 * @author: tomster
 * @data: 2022-11-05 21:09:25
 */
public class Qv1Da2 {
    public static void main(String[] args) {
        Solution solution = new Qv1Da2().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

    class Solution {
        public Node flatten(Node head) {
            Node dummy = new Node(0);
            dummy.next = head;
            while (head != null) {
                if (head.child == null) {
                    head = head.next;
                } else {
                    Node next = head.next;
                    //递归调用
                    Node child = flatten(head.child);
                    //与head相连
                    head.next = child;
                    head.child = null;
                    child.prev = head;
                    //找到child的末节点与next相连
                    Node childLast = child;
                    while (childLast.next != null) {
                        childLast = childLast.next;
                    }
                    childLast.next = next;
                    if (next != null) {
                        next.prev = childLast;
                    }
                    //直接跳到next，中间部分已经处理好
                    head = next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}