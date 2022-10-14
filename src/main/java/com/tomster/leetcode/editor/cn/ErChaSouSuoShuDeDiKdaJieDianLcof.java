/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 340 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-10-14 16:33:21
 */
public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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

        List<Integer> list = new ArrayList<>();

        //二叉搜索树的中序遍历是升序数组
        public int kthLargest(TreeNode root, int k) {
            preOrder(root);
            return list.get(list.size() - k);
        }

        private void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            preOrder(root.left);
            list.add(root.val);
            preOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}