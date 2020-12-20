//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 395 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2020-12-20 11:57:17
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        String[] words = new String[]{"bar", "foo"};
        List<Integer> barfoothefoobarman = solution.findSubstring("barfoothefoobarman", words);
        System.out.println(barfoothefoobarman);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            //字符串的数量和长度
            int wordNum = words.length;
            int wordLen = words[0].length();
            int allLen = wordLen * wordNum;
            //存储字符串的数量
            Map<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }

            for (int i = 0; i < s.length() - allLen + 1; i++) {
                Map<String, Integer> searchMap = new HashMap<>();
                for (int j = 0; j < wordNum; j++) {
                    String curWord = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                    searchMap.put(curWord, searchMap.getOrDefault(curWord, 0) + 1);
                }
                if (searchMap.equals(wordMap)) {
                    result.add(i);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}