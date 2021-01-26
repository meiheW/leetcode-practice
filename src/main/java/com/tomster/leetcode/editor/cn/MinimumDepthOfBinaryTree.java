//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 433 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-01-27 00:03:25
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
         * 这一题给我们一个启示，树这种数据结构在递归的使用上比链表还彻底
         * 这一题用dfs来从顶向下递归，左右节点都为空的情况是结束条件
         * 有一个不为空，或者都为空节点都要继续往下走。
         *
         * p.此题也可以用bfs，耗费空间，但是能在找到最小深度的节点时跳出循环
         *
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //叶子节点
            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left != null && root.right != null) {
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            } else {
                return (root.left == null ? minDepth(root.right) : minDepth(root.left)) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}