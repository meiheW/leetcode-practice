//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 
// 👍 269 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-11-28 11:41:28
 */
public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {//还有一个方案是预处理s，构成一个二维数组，存储每个位置出现下一个字符的坐标，奇思妙想

        //一个一个判断是否子序列
        public String findLongestWord(String s, List<String> dictionary) {
            String ans = "";
            //392题 - 判断子序列
            for (String s1 : dictionary) {
                int p0 = 0, p1 = 0;
                while (p0 < s.length() && p1 < s1.length()) {
                    if (s.charAt(p0) == s1.charAt(p1)) {
                        p1++;
                    }
                    p0++;
                }
                //s1是子序列
                if (p1 == s1.length()) {
                    if (s1.length() > ans.length() || (s1.length() == ans.length() && s1.compareTo(ans) < 0)) {
                        ans = s1;
                    }
                }
            }
            return ans;
        }

        //792类似 成功
        public String findLongestWord1(String s, List<String> dictionary) {
            Map<Character, Deque<WordInfo>> map = new HashMap<>();
            for (char c = 'a'; c <= 'z'; c++) {
                map.putIfAbsent(c, new ArrayDeque<>());
            }
            for (int i = 0; i < dictionary.size(); i++) {
                String word = dictionary.get(i);
                map.get(word.charAt(0)).addLast(new WordInfo(word, i));
            }
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                Deque<WordInfo> wordInfos = map.get(s.charAt(i));
                int size = wordInfos.size();
                for (int j = 0; j < size; j++) {
                    WordInfo wordInfo = wordInfos.pollFirst();
                    String w = wordInfo.word;
                    int index = wordInfo.index;
                    if (w.length() == 1) {
                        String cur = dictionary.get(index);
                        if (cur.length() > ans.length() || (cur.length() == ans.length() && cur.compareTo(ans) < 0)) {
                            ans = cur;
                        }
                    } else {
                        String newWord = w.substring(1);
                        map.get(newWord.charAt(0)).addLast(new WordInfo(newWord, index));
                    }
                }
            }
            return ans;
        }


        class WordInfo {

            String word;
            int index;

            WordInfo(String word, int index) {
                this.word = word;
                this.index = index;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}