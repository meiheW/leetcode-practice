//给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。 
//
// 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。 
//
// 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。 
//
// 返回词汇表 words 中你掌握的所有单词的 长度之和。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["cat","bt","hat","tree"], chars = "atach"
//输出：6
//解释： 
//可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
// 
//
// 示例 2： 
//
// 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//输出：10
//解释：
//可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length, chars.length <= 100 
// 所有字符串中都仅包含小写英文字母 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 142 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 15:56:17
 */
public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        Solution solution = new FindWordsThatCanBeFormedByCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCharacters(String[] words, String chars) {
            int ans = 0;
            Map<Character, Integer> charsMap = wordCount(chars);
            for (String word : words) {
                Map<Character, Integer> wordMap = wordCount(word);
                if (coverMap(charsMap, wordMap)) {
                    ans += word.length();
                }
            }
            return ans;
        }

        private boolean coverMap(Map<Character, Integer> charsMap, Map<Character, Integer> wordMap) {
            for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
                if (!charsMap.containsKey(entry.getKey()) || charsMap.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
            return true;
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