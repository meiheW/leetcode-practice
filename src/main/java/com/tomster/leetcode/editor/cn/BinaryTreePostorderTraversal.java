//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 508 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-01-23 22:37:46
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
         * 方法1：借助前序遍历
         * 后序遍历：左->右->中，前序遍历：中->左->右
         * 前序遍历左右访问顺序交换，结果reverse
         * 即：中左右->中右左->左右中 √
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal1(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    result.add(cur.val);
                    stack.push(cur);
                    cur = cur.right;
                } else {
                    cur = stack.pop();
                    cur = cur.left;
                }
            }
            Collections.reverse(result);
            return result;
        }


        /**
         * 官方解法
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                //左节点先入栈
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                //当右节点为null或者右节点访问过，输出该节点
                if (cur.right == null || cur.right == pre) {
                    result.add(cur.val);
                    pre = cur;//上一个访问的节点
                    cur = null;
                } else {
                    //如果有右节点未被访问，将该节点重新入栈，处理右节点
                    stack.push(cur);
                    cur = cur.right;
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}