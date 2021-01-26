//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 576 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-01-26 23:23:07
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
         * 二叉树平衡的条件：左右子树高度不超过1，且左右子节点也平衡
         * 1.自底向上递归，此题最优解，时间复杂度O(N)
         * 一旦遇到不平衡的子节点，直接返回到根节点
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftH = height(root.left);
            int rightH = height(root.right);
            if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) {
                return -1;
            } else {
                return Math.max(leftH, rightH) + 1;
            }

        }


        /**
         * 2.自顶向下的递归,计算左右子树高度
         * 弊端是下面的节点会被就算多次高度，时间复杂度O(N^2)
         *
         * @param root
         * @return
         */
        public boolean isBalanced1(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
                return false;
            }
            return isBalanced1(root.left) && isBalanced1(root.right);
        }

        /**
         * 树的高度：空节点为0，非空节点为左右子树较大者+1
         *
         * @param node
         * @return
         */
        private int maxDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}