//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 230 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-02-16 21:13:47
 */
public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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
         * 拿到这个题目，仔细一看二叉搜索树，就要联想到中序遍历
         * 中序遍历的结果列表是从小到大有序排列的，这样可以计算前后两个节点值相差的绝对值
         *
         * @param root
         * @return
         */
        public int getMinimumDifference(TreeNode root) {
            inOrderTraversal(root);
            return min;
        }

        TreeNode pre = null;
        int min = Integer.MAX_VALUE;

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            if (pre == null) {
                pre = root;
            } else {
                min = Math.min(min, root.val - pre.val);
                pre = root;
            }
            inOrderTraversal(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}