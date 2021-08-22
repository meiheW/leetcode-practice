//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 输入：s = "", t = "y"
//输出："y"
// 
//
// 示例 3： 
//
// 输入：s = "a", t = "aa"
//输出："a"
// 
//
// 示例 4： 
//
// 输入：s = "ae", t = "aea"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
// Related Topics 位运算 哈希表 字符串 排序 
// 👍 268 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-08-22 16:41:11
 */
public class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            Map<Character, Integer> mapS = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                mapS.put(cur, mapS.getOrDefault(cur, 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                char cur = t.charAt(i);
                if (!mapS.containsKey(cur)) {
                    return cur;
                } else {
                    mapS.put(cur, mapS.get(cur) - 1);
                    if (mapS.get(cur) == 0) {
                        mapS.remove(cur);
                    }
                }
            }
            return 'a';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}