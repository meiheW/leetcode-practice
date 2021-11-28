//给你 root1 和 root2 这两棵二叉搜索树。 
//
// 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
// 
//
// 示例 3： 
//
// 输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
// 
//
// 示例 4： 
//
// 输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
// 
//
// 示例 5： 
//
// 
//
// 输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 5000 个节点。 
// 每个节点的值在 [-10^5, 10^5] 之间。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 
// 👍 70 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-11-28 15:55:00
 */
public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
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
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            dfs(root1, list1);
            List<Integer> list2 = new ArrayList<>();
            dfs(root2, list2);

            List<Integer> ans = new ArrayList<>();
            //归并排序
            int p1 = 0, p2 = 0, n1 = list1.size(), n2 = list2.size();
            while (p1 < n1 && p2 < n2) {
                if (list1.get(p1) <= list2.get(p2)) {
                    ans.add(list1.get(p1));
                    p1++;
                } else {
                    ans.add(list2.get(p2));
                    p2++;
                }
            }
            for (int i = p1; i < n1; i++) {
                ans.add(list1.get(i));
            }
            while (p2 < n2) {
                ans.add(list2.get(p2++));
            }
            return ans;
        }

        private void dfs(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }
            //中序遍历取出有序列表
            dfs(root.left, ans);
            ans.add(root.val);
            dfs(root.right, ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}