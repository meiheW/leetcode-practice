//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 773 👎 0

package com.tomster.leetcode.editor.cn;

import com.sun.deploy.panel.TreeEditors;
import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-02-11 00:00:19
 */
public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
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
         * 递归，区间
         *
         * @param n
         * @return
         */
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> result = new ArrayList<>();
            if (n == 0) {
                return result;
            }
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> nodeList = new ArrayList<>();
            if (start > end) {
                nodeList.add(null);
                return nodeList;
            }

            for (int i = start; i <= end; i++) {
                List<TreeNode> leftNodes = generateTrees(start, i - 1);
                List<TreeNode> rightNodes = generateTrees(i + 1, end);
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftNode;
                        node.right = rightNode;
                        nodeList.add(node);
                    }
                }
            }
            return nodeList;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}