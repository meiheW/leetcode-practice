//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 
// 👍 151 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2021-02-15 17:12:33
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * @param preorder
         * @return
         */
        public boolean isValidSerialization(String preorder) {
            int slots = 1;
            for (String node : preorder.split(",")) {
                if (slots == 0) {
                    return false;
                }
                //当前节点减少一个槽位
                slots--;
                if (!node.equals("#")) {
                    slots += 2;
                }
            }
            return slots == 0;
        }


        /**
         * 这个方法参考反序列化，考虑复杂了
         *
         * @param preorder
         * @return
         */
        public boolean isValidSerialization1(String preorder) {
            if (preorder == null || preorder.isEmpty()) {
                return false;
            }
            LinkedList<String> nodeList = new LinkedList<>();
            for (String str : preorder.split(",")) {
                nodeList.addLast(str);
            }
            //处理后列表为空
            return deserialize(nodeList) && nodeList.isEmpty();
        }

        /**
         * 序列化，取出列表首元素
         * 若列表为空,false;首元素值#,true;否则递归
         *
         * @param nodeList
         * @return
         */
        private boolean deserialize(LinkedList<String> nodeList) {
            if (nodeList.isEmpty()) {
                return false;
            }
            String node = nodeList.removeFirst();
            if ("#".equals(node)) {
                return true;
            }
            return deserialize(nodeList) && deserialize(nodeList);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}