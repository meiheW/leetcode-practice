//给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。 
//
// 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。 
//
// 如果有多种构造方法，请你返回任意一种。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,null,2,null,3,null,4,null,null]
//输出：[2,1,3,null,null,null,4]
//解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
// 
//
// 
//
// 提示： 
//
// 
// 树节点的数目在 1 到 10^4 之间。 
// 树节点的值互不相同，且在 1 到 10^5 之间。 
// 
// Related Topics 二叉搜索树 
// 👍 63 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-06-13 11:12:46
 */
public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new BalanceABinarySearchTree().new Solution();
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

        List<Integer> nodeList = new ArrayList<>();

        public TreeNode balanceBST(TreeNode root) {
            inorderTraversal(root);
            return buildTree(nodeList, 0, nodeList.size() - 1);
        }

        private TreeNode buildTree(List<Integer> nodeList, int begin, int end) {
            if (begin > end) {
                return null;
            }
            int index = (begin + end) / 2;
            TreeNode root = new TreeNode(nodeList.get(index));
            root.left = buildTree(nodeList, begin, index - 1);
            root.right = buildTree(nodeList, index + 1, end);
            return root;
        }

        private void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            nodeList.add(root.val);
            inorderTraversal(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}