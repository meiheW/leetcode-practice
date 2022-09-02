/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
 * preorder-and-inorder-traversal/
 * Related Topics 树 数组 哈希表 分治 二叉树 👍 889 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2022-09-02 16:51:30
 */
public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                   int[] inorder, int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            int rootValue = preorder[preLeft];
            int index = inLeft;
            while (inorder[index] != rootValue) {
                index++;
            }
            int leftLen = index - inLeft;
            TreeNode root = new TreeNode();
            root.val = rootValue;
            root.left = buildTree(preorder, preLeft + 1, preLeft + leftLen,
                    inorder, inLeft, index - 1);
            root.right = buildTree(preorder, preLeft + leftLen + 1, preRight,
                    inorder, index + 1, inRight);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}