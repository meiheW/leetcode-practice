//我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。 
//
// 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，
//但不是 “world” 的子集。 
//
// 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。 
//
// 你可以按任意顺序以列表形式返回 A 中所有的通用单词。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
//输出：["facebook","google","leetcode"]
// 
//
// 示例 2： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
//输出：["apple","google","leetcode"]
// 
//
// 示例 3： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
//输出：["facebook","google"]
// 
//
// 示例 4： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
//输出：["google","leetcode"]
// 
//
// 示例 5： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo
//"]
//输出：["facebook","leetcode"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length, B.length <= 10000 
// 1 <= A[i].length, B[i].length <= 10 
// A[i] 和 B[i] 只由小写字母组成。 
// A[i] 中所有的单词都是独一无二的，也就是说不存在 i != j 使得 A[i] == A[j]。 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 62 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 18:50:28
 */
public class WordSubsets {
    public static void main(String[] args) {
        Solution solution = new WordSubsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordSubsets(String[] words1, String[] words2) {
            Map<Character, Integer> mapB = combineMap(words2);
            List<String> result = new ArrayList<>();
            for (String a : words1) {
                Map<Character, Integer> mapA = wordCount(a);
                if (coverMap(mapA, mapB)) {
                    result.add(a);
                }
            }
            return result;
        }

        private Map<Character, Integer> combineMap(String[] words2) {
            Map<Character, Integer> resultMap = new HashMap<>();
            for (int i = 0; i < words2.length; i++) {
                Map<Character, Integer> map = wordCount(words2[i]);
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (!resultMap.containsKey(entry.getKey())) {
                        resultMap.put(entry.getKey(), entry.getValue());
                    } else {
                        resultMap.put(entry.getKey(), Math.max(entry.getValue(), resultMap.get(entry.getKey())));
                    }
                }
            }
            return resultMap;
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