//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 
// 👍 141 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

/**
 * @author: tomster
 * @data: 2021-02-24 21:54:22
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
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
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            if (pre == null || post == null) {
                return null;
            }

            return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
        }

        public TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
            if (preStart > preEnd || postStart > postEnd) {
                return null;
            }
            if (preStart == preEnd) {
                return new TreeNode(pre[preStart]);
            }
            int preSecond = pre[preStart + 1];
            int index = postStart;
            while (index <= postEnd && post[index] != preSecond) {
                index++;
            }
            int leftLen = index - postStart + 1;
            TreeNode node = new TreeNode(pre[preStart]);
            node.left = constructFromPrePost(pre, post, preStart + 1, preStart + leftLen, postStart, index);
            node.right = constructFromPrePost(pre, post, preStart + leftLen + 1, preEnd, index + 1, postEnd - 1);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}