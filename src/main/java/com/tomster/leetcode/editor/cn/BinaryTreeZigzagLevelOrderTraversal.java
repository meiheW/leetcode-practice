//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 375 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-01-26 23:13:01
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean rightWards = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode pollNode = queue.poll();
                    levelList.add(pollNode.val);
                    if (pollNode.left != null) {
                        queue.add(pollNode.left);
                    }
                    if (pollNode.right != null) {
                        queue.add(pollNode.right);
                    }
                }
                if (!rightWards) {
                    Collections.reverse(levelList);
                }
                rightWards = !rightWards;
                result.add(levelList);
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}