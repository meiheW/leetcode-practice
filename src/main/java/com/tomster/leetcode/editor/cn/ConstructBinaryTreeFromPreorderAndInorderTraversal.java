//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 847 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-01-31 20:40:03
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
         * 前序遍历，中序遍历构建二叉树，递归
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length) {
                return null;
            }
            return reConstruct(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode reConstruct(int preBegin, int preEnd, int inBegin, int inEnd, int[] preorder, int[] inorder) {
            if (preBegin > preEnd || inBegin > inEnd) {
                return null;
            }
            int headVal = preorder[preBegin];
            TreeNode node = new TreeNode(headVal);
            int index = inBegin;
            while (index <= inEnd && inorder[index] != headVal) {
                index++;
            }
            int leftLen = index - inBegin;
            node.left = reConstruct(preBegin + 1, preBegin + leftLen, inBegin, index - 1, preorder, inorder);
            node.right = reConstruct(preBegin + 1 + leftLen, preEnd, index + 1, inEnd, preorder, inorder);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}