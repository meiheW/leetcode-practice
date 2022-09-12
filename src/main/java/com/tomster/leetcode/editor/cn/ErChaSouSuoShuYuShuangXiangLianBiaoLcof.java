/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * <p>
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一
 * 个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
 * to-sorted-doubly-linked-list/
 * <p>
 * 注意：此题对比原题有改动。
 * Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 576 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.search.Node;

/**
 * @author: tomster
 * @data: 2022-09-12 11:59:56
 */
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {

        Node head, pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            pre.right = head;
            head.left = pre;
            return head;
        }

        public void dfs(Node cur) {
            if (cur == null) return;
            dfs(cur.left);
            //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
            if (pre == null) head = cur;
                //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
            else pre.right = cur;
            cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
            pre = cur;//pre指向当前的cur
            dfs(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}