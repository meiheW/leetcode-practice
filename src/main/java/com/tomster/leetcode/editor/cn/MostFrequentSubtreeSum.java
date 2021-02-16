//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 103 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: tomster
 * @data: 2021-02-16 11:24:36
 */
public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(-3);
        root.left = root1;
        root.right = root2;
        solution.findFrequentTreeSum(root);
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
        HashMap<Integer, Integer> map = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            postOrderTraversal(root);
            List<Integer> collect = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            if (collect.isEmpty()) {
                return new int[0];
            }
            int maxCount = collect.get(0);
            List<Integer> resultList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    resultList.add(entry.getKey());
                }
            }
            int[] resultArr = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                resultArr[i] = resultList.get(i);
            }
            return resultArr;
        }

        private int postOrderTraversal(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sumLeft = postOrderTraversal(root.left);
            int sumRight = postOrderTraversal(root.right);
            int sumRoot = sumLeft + root.val + sumRight;
            map.put(sumRoot, map.getOrDefault(sumRoot, 0) + 1);
            return sumRoot;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}