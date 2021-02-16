//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 124 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-02-16 21:01:40
 */
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return result;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = queue.peek().val;
                for (int i = 0; i < size; i++) {
                    TreeNode first = queue.poll();
                    if (first.val > max) {
                        max = first.val;
                    }
                    if (first.left != null) {
                        queue.offer(first.left);
                    }
                    if (first.right != null) {
                        queue.offer(first.right);
                    }
                }
                result.add(max);
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}