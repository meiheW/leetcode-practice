//字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。 
//
// S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。 
//
// 返回任意一种符合条件的字符串T。 
//
// 
//示例:
//输入:
//S = "cba"
//T = "abcd"
//输出: "cbad"
//解释: 
//S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a". 
//由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
// 
//
// 注意: 
//
// 
// S的最大长度为26，其中没有重复的字符。 
// T的最大长度为200。 
// S和T只包含小写字符。 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 87 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-09-14 09:46:25
 */
public class CustomSortString {
    public static void main(String[] args) {
        Solution solution = new CustomSortString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String order, String s) {
            int[] orderArr = new int[26];
            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                orderArr[c - 'a'] = i + 1;
            }
            List<Character> cList = new ArrayList<>();
            for (char c : s.toCharArray()) {
                cList.add(c);
            }
            cList.sort(Comparator.comparingInt(o -> orderArr[o - 'a']));
            StringBuilder sb = new StringBuilder();
            for (Character c : cList) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}