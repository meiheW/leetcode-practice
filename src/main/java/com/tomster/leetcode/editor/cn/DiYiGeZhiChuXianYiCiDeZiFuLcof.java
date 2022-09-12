/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：s = ""
 * 输出：' '
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * Related Topics 队列 哈希表 字符串 计数 👍 264 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2022-09-12 16:10:36
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            if (s == null || s.length() == 0) {
                return ' ';
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char c : s.toCharArray()) {
                if (map.get(c) == 1) {
                    return c;
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}