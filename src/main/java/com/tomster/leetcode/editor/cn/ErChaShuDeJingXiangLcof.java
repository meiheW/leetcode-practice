/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * / \
 * 2 7
 * / \ / \
 * 1 3 6 9
 * 镜像输出：
 * <p>
 * 4
 * / \
 * 7 2
 * / \ / \
 * 9 6 3 1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 307 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2022-09-09 14:33:51
 */
public class ErChaShuDeJingXiangLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
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
        public TreeNode mirrorTree(TreeNode root) {
            if(root==null){
                return root;
            }
            TreeNode mirrorLeft = mirrorTree(root.left);
            TreeNode mirrorRight = mirrorTree(root.right);
            root.left = mirrorRight;
            root.right = mirrorLeft;
            return root;
        }

        public TreeNode mirrorTree1(TreeNode root) {
            if (root == null) {
                return null;
            }
            //交换左右子树
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirrorTree1(root.left);
            mirrorTree1(root.right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}