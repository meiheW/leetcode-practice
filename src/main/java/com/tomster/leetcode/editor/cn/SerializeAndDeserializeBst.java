//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 104] 
// 0 <= Node.val <= 104 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 
// 👍 186 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-06-06 01:16:44
 */
public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder().append(root.val).append(",");
            String left = serialize(root.left);
            String right = serialize(root.right);
            if (left != null) {
                sb.append(left);
            }
            if (right != null) {
                sb.append(right);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            List<String> list = Arrays.asList(data.split(","));
            if (list.size() == 0) {
                return null;
            }
            int[] nums = new int[list.size()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(list.get(i));
            }
            return bstFromPreorder(nums, 0, nums.length - 1);
        }


        private TreeNode bstFromPreorder(int[] preorder, int begin, int end) {
            if (begin > end || end > preorder.length) {
                return null;
            }
            int rootVal = preorder[begin];
            int index = begin + 1;
            while (index <= end && preorder[index] <= rootVal) {
                index++;
            }
            TreeNode root = new TreeNode(rootVal);
            root.left = bstFromPreorder(preorder, begin + 1, index - 1);
            root.right = bstFromPreorder(preorder, index, end);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}