//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 413 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-08-22 19:23:52
 */
public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> map1 = wordCount(s1);
            int l1 = s1.length();
            int l2 = s2.length();
            if (l1 > l2) {
                return false;
            } else {
                Map<Character, Integer> scanMap = wordCount(s2.substring(0, l1));
                if (sameMap(scanMap, map1)) {
                    return true;
                }
                for (int i = 0; i < l2 - l1; i++) {
                    char c = s2.charAt(i);
                    char nc = s2.charAt(i + l1);
                    scanMap.put(nc, scanMap.getOrDefault(nc, 0) + 1);
                    scanMap.put(c, scanMap.get(c) - 1);
                    if (scanMap.get(c) == 0) {
                        scanMap.remove(c);
                    }
                    if (sameMap(scanMap, map1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private Map<Character, Integer> wordCount(String licensePlate) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : licensePlate.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}