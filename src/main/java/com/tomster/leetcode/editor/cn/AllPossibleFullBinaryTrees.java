//满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。 
//
// 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。 
//
// 答案中每个树的每个结点都必须有 node.val=0。 
//
// 你可以按任何顺序返回树的最终列表。 
//
// 
//
// 示例： 
//
// 输入：7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//解释：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 20 
// 
// Related Topics 树 递归 
// 👍 179 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-02-28 18:51:44
 */
public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
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
        public List<TreeNode> allPossibleFBT(int N) {
            List<TreeNode> result = new ArrayList<>();
            if (N % 2 == 0) {
                return result;
            }
            if (N == 1) {
                TreeNode node = new TreeNode(0);
                result.add(node);
                return result;
            }

            for (int i = 1; i < N; i += 2) {
                List<TreeNode> leftNodes = allPossibleFBT(i);
                List<TreeNode> rightNodes = allPossibleFBT(N - 1 - i);
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode node = new TreeNode(0);
                        node.left = leftNode;
                        node.right = rightNode;
                        result.add(node);
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}