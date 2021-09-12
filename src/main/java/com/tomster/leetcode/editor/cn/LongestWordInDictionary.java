//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 
// 👍 156 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-12 20:55:15
 */
public class LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            Arrays.sort(words);
            Map<String, Boolean> map = new HashMap<>();
            for (String word : words) {
                if (word.length() == 1) {
                    map.put(word, true);
                } else {
                    map.put(word, Boolean.TRUE.equals(map.get(word.substring(0, word.length() - 1))));
                }
            }
            String result = "";
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                if (entry.getValue()) {
                    if (entry.getKey().length() > result.length()) {
                        result = entry.getKey();
                    } else if (entry.getKey().length() == result.length()) {
                        if (entry.getKey().compareTo(result) < 0) {
                            result = entry.getKey();
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}