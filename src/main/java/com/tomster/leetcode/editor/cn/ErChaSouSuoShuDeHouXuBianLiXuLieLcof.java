/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 数组长度 <= 1000
 * <p>
 * Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 605 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-11 14:15:50
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return verifyPostorder(postorder, 0, postorder.length - 1);
        }

        private boolean verifyPostorder(int[] arr, int left, int right) {
            if (left >= right) {
                return true;
            }
            int i = left;
            while (i < right && arr[i] < arr[right]) {
                i++;
            }
            int j = i;
            while (j < right && arr[j] > arr[right]) {
                j++;
            }
            return j == right && verifyPostorder(arr, left, i - 1)
                    && verifyPostorder(arr, i, right - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}