//给定一个二叉树，在树的最后一行找到最左边的值。 
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 148 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2021-02-16 19:44:12
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
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
         * 层序遍历最后一行第一个
         * 这个方法，还是左右方向，可以改成先右后左，这样最后一个就是底层左边的节点了
         *
         * @param root
         * @return
         */
        public int findBottomLeftValue1(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            int lastLeft = root.val;
            list.addLast(root);
            while (!list.isEmpty()) {
                int size = list.size();
                lastLeft = list.get(0).val;
                for (int i = 0; i < size; i++) {
                    TreeNode node = list.removeFirst();
                    if (node.left != null) {
                        list.addLast(node.left);
                    }
                    if (node.right != null) {
                        list.addLast(node.right);
                    }
                }
            }
            return lastLeft;
        }


        public int findBottomLeftValue(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.addLast(root);
            TreeNode node = null;
            while (!list.isEmpty()) {
                node = list.removeFirst();
                if (node.right != null) {
                    list.addLast(node.right);
                }
                if (node.left != null) {
                    list.addLast(node.left);
                }
            }
            return node.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}