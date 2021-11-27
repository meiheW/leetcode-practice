//你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [
//attacki, defensei] 表示游戏中第 i 个角色的属性。 
//
// 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j
// ，那么 attackj > attacki 且 defensej > defensei 。 
//
// 返回 弱角色 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：properties = [[5,5],[6,3],[3,6]]
//输出：0
//解释：不存在攻击和防御都严格高于其他角色的角色。
// 
//
// 示例 2： 
//
// 
//输入：properties = [[2,2],[3,3]]
//输出：1
//解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 示例 3： 
//
// 
//输入：properties = [[1,5],[10,4],[4,3]]
//输出：1
//解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= properties.length <= 105 
// properties[i].length == 2 
// 1 <= attacki, defensei <= 105 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 
// 👍 32 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-11-07 20:01:09
 */
public class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {
        Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfWeakCharacters1(int[][] properties) {
            //攻击力递减，攻击力相同防御力递增
            Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0]
                    ? Integer.compare(o1[1], o2[1])
                    : Integer.compare(o2[0], o1[0]));
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            //这边用了栈，栈顶元素是防御力最大值，其实遍历过程中只需要保存防御力最大值即可
            for (int[] property : properties) {
                if (!stack.isEmpty() && stack.peek() > property[1]) {
                    ans++;
                } else {
                    stack.add(property[1]);
                }
            }
            return ans;
        }

        public int numberOfWeakCharacters(int[][] properties) {
            //attack降序排列，相同情况下defense升序排列
            Arrays.sort(properties, (o1, o2) -> o1[0] != o2[0] ?
                    Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
            int ans = 0;
            int maxDef = -1;
            //攻击力相同，防御力是递增的，所以小于maxDef，肯定攻击力也小
            for (int[] property : properties) {
                if (property[1] < maxDef) {
                    ans++;
                } else {
                    maxDef = property[1];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}