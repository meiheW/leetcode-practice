/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4 5
 * / \
 * 1 2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * Related Topics 树 深度优先搜索 二叉树 👍 635 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2022-09-09 13:12:58
 */
public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            return isRootStructure(A, B) || isSubStructure(A.left, B)
                    || isSubStructure(A.right, B);
        }

        private boolean isRootStructure(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }
            if (a == null) {
                return false;
            }
            if (a.val != b.val) {
                return false;
            }
            return isRootStructure(a.left, b.left) && isRootStructure(a.right, b.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}