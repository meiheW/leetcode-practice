//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 字符串 
// 👍 378 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-08-22 11:47:11
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：s = "egg", t = "add"
        //输出：true
        public boolean isIsomorphic(String s, String t) {
            int n = s.length();
            Map<Character, Character> mapS = new HashMap<>();
            Map<Character, Character> mapT = new HashMap<>();

            for (int i = 0; i < n; i++) {
                char keyS = s.charAt(i);
                char keyT = t.charAt(i);
                if (mapS.containsKey(keyS) && !mapS.get(keyS).equals(keyT)) {
                    return false;
                }
                if (mapT.containsKey(keyT) && !mapT.get(keyT).equals(keyS)) {
                    return false;
                }
                mapS.put(keyS, keyT);
                mapT.put(keyT, keyS);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}