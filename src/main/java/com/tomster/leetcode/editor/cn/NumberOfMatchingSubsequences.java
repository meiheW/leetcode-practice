//给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。 
//
// 
//示例:
//输入: 
//S = "abcde"
//words = ["a", "bb", "acd", "ace"]
//输出: 3
//解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
// 
//
// 注意: 
//
// 
// 所有在words和 S 里的单词都只由小写字母组成。 
// S 的长度在 [1, 50000]。 
// words 的长度在 [1, 5000]。 
// words[i]的长度在[1, 50]。 
// 
// Related Topics 字典树 哈希表 字符串 排序 
// 👍 164 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 09:47:57
 */
public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        Solution solution = new NumberOfMatchingSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入: S = "abcde", words = ["a", "bb", "acd", "ace"]
        //输出: 3
        public int numMatchingSubseq(String s, String[] words) {
            Map<Character, Deque<String>> map = new HashMap<>();
            for (char c = 'a'; c <= 'z'; c++) {
                map.putIfAbsent(c, new ArrayDeque<>());
            }
            for (String word : words) {
                map.get(word.charAt(0)).addLast(word);
            }
            int ans = 0;
            for (char cur : s.toCharArray()) {
                Deque<String> deque = map.get(cur);
                int size = deque.size();//这个不能放进循环条件
                for (int i = 0; i < size; i++) {
                    String str = deque.removeFirst();
                    if (str.length() == 1) {
                        ans++;
                    } else {
                        map.get(str.charAt(1)).addLast(str.substring(1));
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}