//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树 
// 👍 218 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-02-19 22:48:57
 */
public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
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
         * 类似两数之和，考察哈希，但是这种解法好像没有利用BST的性质
         *
         * @param root
         * @param k
         * @return
         */
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            return findTarget(root, k, set);
        }

        private boolean findTarget(TreeNode root, int k, Set<Integer> set) {
            if (root == null) {
                return false;
            }
            if (set.contains(root.val)) {
                return true;
            }
            set.add(k - root.val);
            return findTarget(root.left, k, set) || findTarget(root.right, k, set);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}