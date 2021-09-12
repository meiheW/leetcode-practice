//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
// 👍 381 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-05-15 13:06:21
 */
public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) {
                return s == null && t == null;
            }
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                count[c - 'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    return false;
                }
            }
            return true;
        }


        public boolean isAnagram1(String s, String t) {
            Map<Character, Integer> mapS = getCharMap(s);
            Map<Character, Integer> mapT = getCharMap(t);
            return sameMap(mapS, mapT);
        }

        private boolean sameMap(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
            if (mapS == null || mapT == null) {
                return mapS == null && mapT == null;
            }
            if (mapS.size() != mapT.size()) {
                return false;
            }
            for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
                if (!entry.getValue().equals(mapT.get(entry.getKey()))) {
                    return false;
                }
            }

            return true;
        }

        private Map<Character, Integer> getCharMap(String s) {
            Map<Character, Integer> map = new HashMap<>();
            if (s == null) {
                return map;
            }
            char[] chars = s.toCharArray();
            for (char c : chars) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}