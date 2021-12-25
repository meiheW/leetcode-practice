//给出一个单词列表，其中每个单词都由小写英文字母组成。 
//
// 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac
//" 的前身。 
//
// 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_
//2 是 word_3 的前身，依此类推。 
//
// 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。 
// 
//
// 示例： 
//
// 输入：["a","b","ba","bca","bda","bdca"]
//输出：4
//解释：最长单词链之一为 "a","ba","bda","bdca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] 仅由小写英文字母组成。 
// 
//
// 
// Related Topics 数组 哈希表 双指针 字符串 动态规划 
// 👍 150 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-12-25 23:23:35
 */
public class LongestStringChain {
    public static void main(String[] args) {
        Solution solution = new LongestStringChain().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            Map<String, Integer> map = new HashMap<>();
            int ans = 0;
            for (String word : words) {
                int count = 0;
                for (int i = 0; i < word.length(); i++) {//本质也是动态规划
                    String sub = word.substring(0, i) + word.substring(i + 1);
                    count = Math.max(count, map.getOrDefault(sub, 0) + 1);
                }
                map.put(word, count);
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}