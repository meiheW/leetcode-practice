//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 字符串 
// 👍 370 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-08-22 15:23:20
 */
public class WordPattern {
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            Map<Character, String> mapP = new HashMap<>();
            Map<String, Character> mapS = new HashMap<>();
            String[] wordArr = s.split(" ");
            if (wordArr.length != pattern.length()) {
                return false;
            }
            int n = pattern.length();

            for (int i = 0; i < n; i++) {
                char cur = pattern.charAt(i);
                String str = wordArr[i];
                if (mapP.containsKey(cur) && !str.equals(mapP.get(cur))) {
                    return false;
                }
                if (mapS.containsKey(str) && !mapS.get(str).equals(cur)) {
                    return false;
                }
                mapP.put(cur, str);
                mapS.put(str, cur);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}