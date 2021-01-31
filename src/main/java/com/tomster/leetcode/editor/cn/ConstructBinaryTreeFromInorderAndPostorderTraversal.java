//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 440 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author: tomster
 * @data: 2021-01-31 21:20:12
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return reConstruct(0, postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
        }

        private TreeNode reConstruct(int postBegin, int postEnd, int inBegin, int inEnd, int[] postorder, int[] inorder) {
            if (postBegin > postEnd || inBegin > inEnd) {
                return null;
            }
            int headVal = postorder[postEnd];
            TreeNode node = new TreeNode(headVal);
            int index = inBegin;
            while (index <= inEnd && inorder[index] != headVal) {
                index++;
            }
            int leftLen = index - inBegin;
            node.left = reConstruct(postBegin, postBegin + leftLen - 1, inBegin, index - 1, postorder, inorder);
            node.right = reConstruct(postBegin + leftLen, postEnd - 1, index + 1, inEnd, postorder, inorder);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}