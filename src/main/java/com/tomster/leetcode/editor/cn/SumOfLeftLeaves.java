//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 280 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-02-17 11:34:54
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 前序遍历
         * @param root
         * @return
         */
        public int sumOfLeftLeaves1(TreeNode root) {
            traversal(root);
            return sum;
        }

        int sum;

        private void traversal(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode leftNode = root.left;
            if (leftNode != null && leftNode.left == null && leftNode.right == null) {
                sum += leftNode.val;
            }

            traversal(root.left);
            traversal(root.right);
        }


        /**
         * 递归
         * @param root
         * @return
         */
        public int sumOfLeftLeaves(TreeNode root) {
            if(root==null) return 0;
            return sumOfLeftLeaves(root.left)
                    + sumOfLeftLeaves(root.right)
                    + (root.left!=null && root.left.left==null && root.left.right==null ? root.left.val : 0);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}