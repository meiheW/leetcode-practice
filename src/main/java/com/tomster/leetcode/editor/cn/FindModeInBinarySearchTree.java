//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 268 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-02-15 22:12:26
 */
public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(111);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        max.ifPresent(System.out::println);
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

        List<Integer> result = new ArrayList<>();
        int base, count, maxCount;

        public int[] findMode(TreeNode root) {
            inorderTraversal(root);
            int[] resultArr = new int[result.size()];
            for (int i = 0; i < resultArr.length; i++) {
                resultArr[i] = result.get(i);
            }
            return resultArr;
        }

        private void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            process(root.val);
            inorderTraversal(root.right);
        }

        private void process(int val) {
            if (val == base) {
                count++;
            } else {
                base = val;
                count = 1;
            }
            if (count == maxCount) {
                result.add(base);
            } else if (count > maxCount) {
                result.clear();
                result.add(base);
                maxCount = count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}