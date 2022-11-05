/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * <p>
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2]
 * 输出: false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表 L 的长度范围为 [1, 10⁵]
 * 0 <= node.val <= 9
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/
 * Related Topics 栈 递归 链表 双指针 👍 83 👎 0
 */
package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-11-05 20:58:08
 */
public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                if (list.get(i).intValue() != list.get(j).intValue()) {
                    return false;
                }
                ++i;
                --j;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}