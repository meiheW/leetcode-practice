//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 136 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-08-22 18:36:24
 */
public class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String[] findWords(String[] words) {
            String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            int[] rowArr = new int[26];
            for (int i = 0; i < 3; i++) {
                String row = rows[i];
                for (int j = 0; j < row.length(); j++) {
                    rowArr[row.charAt(j) - 'a'] = i;
                }
            }
            List<String> ans = new ArrayList<>();
            for (String word : words) {
                int index = rowArr[Character.toLowerCase(word.charAt(0)) - 'a'];
                boolean sameRow = true;
                for (int i = 1; i < word.length(); i++) {
                    if (rowArr[Character.toLowerCase(word.charAt(i)) - 'a'] != index) {
                        sameRow = false;
                        break;
                    }
                }
                if (sameRow) {
                    ans.add(word);
                }
            }
            String[] result = new String[ans.size()];

            ans.toArray(result);
            return result;
        }

        public String[] findWords1(String[] words) {
            Map<Character, Integer> map = new HashMap<>();
            String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            for (int i = 0; i < rows.length; i++) {
                for (char c : rows[i].toCharArray()) {
                    map.put(c, i);
                }
            }
            List<String> resultList = new ArrayList<>();
            for (String word : words) {
                char[] chars = word.toCharArray();
                char first = chars[0] >= 'A' && chars[0] <= 'Z' ? (char) (chars[0] + 32) : chars[0];
                int row = map.get(first);
                boolean sameRow = true;
                for (char c : chars) {
                    char cc = c >= 'A' && c <= 'Z' ? (char) (c + 32) : c;
                    if (row != map.get(cc)) {
                        sameRow = false;
                        break;
                    }
                }
                if (sameRow) {
                    resultList.add(word);
                }
            }
            String[] result = new String[resultList.size()];

            resultList.toArray(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}