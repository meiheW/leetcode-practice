//在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则： 
//
// 
// 行数 m 应当等于给定二叉树的高度。 
// 列数 n 应当总是奇数。 
// 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分
//，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，
//如果两个子树都为空则不需要为它们留出任何空间。 
// 每个未使用的空间应包含一个空的字符串""。 
// 使用相同的规则输出子树。 
// 
//
// 示例 1: 
//
// 
//输入:
//     1
//    /
//   2
//输出:
//[["", "1", ""],
// ["2", "", ""]]
// 
//
// 示例 2: 
//
// 
//输入:
//     1
//    / \
//   2   3
//    \
//     4
//输出:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
//
// 示例 3: 
//
// 
//输入:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//输出:
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 
//
// 注意: 二叉树的高度在范围 [1, 10] 中。 
// Related Topics 树 
// 👍 93 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-02-23 22:48:38
 */
public class PrintBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PrintBinaryTree().new Solution();
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
        public List<List<String>> printTree(TreeNode root) {
            List<List<String>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            //init matrix
            int row = maxHeight(root);
            int col = (int) Math.pow(2, row) - 1;
            for (int i = 0; i < row; i++) {
                List<String> rowList = new ArrayList<>();
                for (int j = 0; j < col; j++) {
                    rowList.add("");
                }
                result.add(rowList);
            }
            //recursion
            print(root, 0, 0, col - 1, result);
            return result;
        }

        private void print(TreeNode root, int r, int start, int end, List<List<String>> result) {
            if (root == null || r >= result.size()) {
                return;
            }
            List<String> curRowList = result.get(r);
            int middle = start + (end - start) / 2;
            curRowList.set(middle, String.valueOf(root.val));

            print(root.left, r + 1, start, middle - 1, result);
            print(root.right, r + 1, middle + 1, end, result);
        }

        private int maxHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}