/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 节点总数 <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
 * traversal/
 * Related Topics 树 广度优先搜索 二叉树 👍 249 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author: tomster
 * @data: 2022-09-09 19:08:08
 */
public class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> list = new LinkedList<>();
            list.addLast(root);
            List<List<Integer>> ans = new ArrayList<>();
            while (!list.isEmpty()) {
                List<Integer> row = new ArrayList<>();
                for (TreeNode node : list) {
                    row.add(node.val);
                }
                ans.add(row);
                for (int i = 0; i < row.size(); i++) {
                    TreeNode first = list.pollFirst();
                    if (first.left != null) {
                        list.addLast(first.left);
                    }
                    if (first.right != null) {
                        list.addLast(first.right);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}