//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 358 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: tomster
 * @data: 2021-02-11 15:20:22
 */
public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        /**
         * 解法一： 第一反应层序遍历
         *
         * @param root
         * @return
         */
        public Node connect1(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node pollNode = queue.poll();
                    if (pollNode.left != null) {
                        queue.offer(pollNode.left);
                    }
                    if (pollNode.right != null) {
                        queue.offer(pollNode.right);
                    }

                    if (pre == null) {
                        pre = pollNode;
                    } else {
                        pre.next = pollNode;
                        pre = pre.next;
                    }

                }
            }
            return root;

        }


        /**
         * 解法二：利用上一层的next指针实现下一层的连接
         *
         * @param root
         * @return
         */
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Node cur = root;
            while (cur != null) {
                Node dummy = new Node(1);
                Node pre = dummy;
                while (cur != null) {
                    if (cur.left != null) {
                        pre.next = cur.left;
                        pre = cur.left;
                    }
                    if (cur.right != null) {
                        pre.next = cur.right;
                        pre = cur.right;
                    }
                    cur = cur.next;
                }
                cur = dummy.next;
            }
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}