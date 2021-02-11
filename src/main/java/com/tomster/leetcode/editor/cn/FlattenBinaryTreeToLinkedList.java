//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 树 深度优先搜索 
// 👍 718 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-02-11 13:54:38
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 解法一：
         * 将右子树放到左子树的最右边节点，
         * 然后将左子树放到右子树的位置，
         * 新的右子节点作为root遍历，左子节点设为null
         *
         * @param root
         */
        public void flatten1(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left == null) {
                    cur = cur.right;
                } else {
                    TreeNode leftNode = cur.left;
                    while (leftNode.right != null) {
                        leftNode = leftNode.right;
                    }
                    leftNode.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                    cur = cur.right;
                }
            }
        }


        /**
         * 方法2：递归
         *
         * @param root
         */
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);

            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            root.right = leftNode;
            root.left = null;
            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = rightNode;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}