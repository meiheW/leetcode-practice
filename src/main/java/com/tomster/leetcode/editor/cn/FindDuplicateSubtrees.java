//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 229 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-02-13 14:05:32
 */
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
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

        List<TreeNode> result = new ArrayList<>();
        HashMap<String, Integer> record = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            postOrderTraversal(root);
            return result;
        }

        private String postOrderTraversal(TreeNode root) {
            //后序遍历序列化
            if (root == null) {
                return "#";
            }
            String leftStr = postOrderTraversal(root.left);
            String rightStr = postOrderTraversal(root.right);
            String cur = leftStr + "," + rightStr + "," + root.val;

            Integer times = record.getOrDefault(cur, 0);
            record.put(cur, times + 1);
            if (times == 1) {
                result.add(root);
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}