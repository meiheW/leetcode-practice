//返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。 
//
// (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right
// 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。） 
//
// 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。 
//
// 
//
// 示例： 
//
// 输入：[8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 10^8 
// preorder 中的值互不相同 
// 
// Related Topics 树 
// 👍 149 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-06-06 00:43:26
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
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
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            return bstFromPreorder(preorder, 0, preorder.length - 1);
        }

        private TreeNode bstFromPreorder(int[] preorder, int begin, int end) {
            if (begin > end || end > preorder.length) {
                return null;
            }
            int rootVal = preorder[begin];
            int index = begin + 1;
            while (index <= end && preorder[index] <= rootVal) {
                index++;
            }
            TreeNode root = new TreeNode(rootVal);
            root.left = bstFromPreorder(preorder, begin + 1, index - 1);
            root.right = bstFromPreorder(preorder, index, end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}