//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 贪心 哈希表 字符串 
// 👍 323 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-08-22 17:32:32
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            Set<Character> set = new HashSet<>();
            int size = 0;
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (set.contains(cur)) {
                    set.remove(cur);
                    size += 2;
                } else {
                    set.add(cur);
                }
            }
            return size + (set.isEmpty() ? 0 : 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}