//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 443 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-02-16 23:07:29
 */
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
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
         * 这一题在判断两棵树是否相等基础上做的[100题]
         * 其实也可以用树的序列化来做，后序遍历，对s每个节点序列化与t进行比较
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null || t == null) {
                return s == null && t == null;
            }
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        public boolean isSameTree(TreeNode node1, TreeNode node2) {
            if (node1 == null || node2 == null) {
                return node1 == null && node2 == null;
            }
            return node1.val == node2.val && isSameTree(node1.left, node2.left)
                    && isSameTree(node1.right, node2.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}