//你有一个单词列表 words 和一个模式 pattern，你想知道 words 中的哪些单词与模式匹配。 
//
// 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。 
//
// （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。） 
//
// 返回 words 中与给定模式匹配的单词列表。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例： 
//
// 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//输出：["mee","aqq"]
//解释：
//"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//因为 a 和 b 映射到同一个字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 50 
// 1 <= pattern.length = words[i].length <= 20 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 104 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-08-22 14:31:42
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        Solution solution = new FindAndReplacePattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> result = new ArrayList<>();
            if (words == null || pattern == null) {
                return result;
            }
            for (String word : words) {
                if (isIsomorphic(word, pattern)) {
                    result.add(word);
                }
            }
            return result;
        }

        /**
         * 205.同构字符串
         */
        private boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int n = s.length();
            int[] sa = new int[26];
            int[] ta = new int[26];

            for (int i = 0; i < n; i++) {
                if (sa[s.charAt(i) - 'a'] != ta[t.charAt(i) - 'a']) {
                    return false;
                }
                sa[s.charAt(i) - 'a'] = i + 1;
                ta[t.charAt(i) - 'a'] = i + 1;
            }
            return true;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}