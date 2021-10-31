//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答
//案。
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 243 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-10-31 20:59:01
 */
public class FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {
            int[] ans = new int[26];
            Arrays.fill(ans, 100);
            for (String word : words) {
                int[] cur = new int[26];
                for (char c : word.toCharArray()) {
                    cur[c - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    ans[i] = Math.min(ans[i], cur[i]);
                }
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                int k = ans[i];
                while (k-- > 0) {
                    list.add(String.valueOf((char) ('a' + i)));
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}