//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 
// 👍 136 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-02-24 21:48:18
 */
public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
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
         * 递归
         * 这个题目有点绕，写这种题目先理清逻辑
         * 不要陷进递归的逻辑内部去，这个函数就是找到树的第二小的值
         * 再加上提干条件
         * a. root.val = min(root.left.val, root.right.val)
         * b. 一个节点有0或者2个子节点
         *
         * @param root
         * @return
         */
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null) {
                return -1;
            }
            if (root.left == null && root.right == null) {
                return -1;
            }
            int leftSecMin = findSecondMinimumValue(root.left);
            int rightSecMin = findSecondMinimumValue(root.right);
            //左右节点值相等
            if (root.left.val == root.right.val) {
                if (leftSecMin == -1 || rightSecMin == -1) {
                    return leftSecMin == -1 ? rightSecMin : leftSecMin;
                } else {
                    return Math.min(leftSecMin, rightSecMin);
                }
            } else {
                //左右节点值不相等
                TreeNode maxNode = root.left.val == root.val ? root.right : root.left;
                TreeNode minNode = root.left.val == root.val ? root.left : root.right;
                int minNodeSecMin = findSecondMinimumValue(minNode);
                if (minNodeSecMin == -1) {
                    return maxNode.val;
                } else {
                    return Math.min(maxNode.val, minNodeSecMin);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}