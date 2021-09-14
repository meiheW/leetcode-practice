//给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。） 
//
// 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。 
//
// 返回所有不常用单词的列表。 
//
// 您可以按任何顺序返回列表。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = "this apple is sweet", B = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 输入：A = "apple apple", B = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 200 
// 0 <= B.length <= 200 
// A 和 B 都只包含空格和小写字母。 
// 
// Related Topics 哈希表 字符串 
// 👍 92 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 11:39:49
 */
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> map1 = wordCount(s1);
            Map<String, Integer> map2 = wordCount(s2);
            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                if (entry.getValue() == 1 && !map2.containsKey(entry.getKey())) {
                    result.add(entry.getKey());
                }
            }
            for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                if (entry.getValue() == 1 && !map1.containsKey(entry.getKey())) {
                    result.add(entry.getKey());
                }
            }

            return result.toArray(new String[0]);
        }

        private Map<String, Integer> wordCount(String sentence) {
            Map<String, Integer> map = new HashMap<>();
            for (String s : sentence.split(" ")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}