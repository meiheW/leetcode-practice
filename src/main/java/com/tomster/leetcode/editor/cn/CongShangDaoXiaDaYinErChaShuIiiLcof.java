/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 * [20,9],
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
 * Related Topics 树 广度优先搜索 二叉树 👍 252 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-09-12 13:21:35
 */
public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
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
            boolean right = true;
            while (!list.isEmpty()) {
                List<Integer> row = new ArrayList<>();
                int size = list.size();
                if (right) {
                    for (int i = 0; i < size; i++) {
                        row.add(list.get(i).val);
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        row.add(list.get(size - 1 - i).val);
                    }
                }
                ans.add(row);
                right = !right;
                for (int i = 0; i < size; i++) {
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