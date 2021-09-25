//给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。 
//
// 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abacbc"
//输出：true
//解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
// 
//
// 示例 2： 
//
// 输入：s = "aaabb"
//输出：false
//解释：s 中出现过的字符为 'a' 和 'b' 。
//'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母。 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 1 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 23:07:04
 */
public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new CheckIfAllCharactersHaveEqualNumberOfOccurrences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areOccurrencesEqual(String s) {
            Map<Character, Integer> map = wordCount(s);
            return new HashSet<>(map.values()).size() == 1;
        }

        private Map<Character, Integer> wordCount(String licensePlate) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : licensePlate.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}