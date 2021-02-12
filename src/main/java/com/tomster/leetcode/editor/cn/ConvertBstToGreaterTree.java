//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 104 之间。 
// 每个节点的值介于 -104 和 104 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 递归 
// 👍 466 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-02-13 00:34:12
 */
public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
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
         * 二叉搜索树，第一反应结合中序遍历
         * 1.递归方法
         *
         * @param root
         * @return
         */
        public TreeNode convertBST1(TreeNode root) {
            return inOrderTraversal(root);
        }

        int pre = 0;

        private TreeNode inOrderTraversal(TreeNode root) {
            if (root == null) {
                return null;
            }
            inOrderTraversal(root.right);
            root.val = root.val + pre;
            pre = root.val;
            inOrderTraversal(root.left);
            return root;
        }


        /**
         * 中序迭代
         *
         * @param root
         * @return
         */
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            int pre = 0;
            TreeNode cur = root;
            Stack<TreeNode> stack = new Stack<>();
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.right;
                } else {
                    cur = stack.pop();
                    cur.val = cur.val + pre;
                    pre = cur.val;
                    cur = cur.left;
                }
            }
            return root;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}