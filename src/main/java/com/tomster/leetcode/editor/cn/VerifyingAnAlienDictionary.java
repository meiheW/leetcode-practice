//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。 
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 fals
//e。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//输出：true
//解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。 
//
// 示例 2： 
//
// 
//输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//输出：false
//解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。 
//
// 示例 3： 
//
// 
//输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//输出：false
//解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅'
// 是空白字符，定义为比任何其他字符都小（更多信息）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// 在 words[i] 和 order 中的所有字符都是英文小写字母。 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 85 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-09-14 20:00:28
 */
public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        Solution solution = new VerifyingAnAlienDictionary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] orderArr = new int[26];
            for (int i = 0; i < order.length(); i++) {
                orderArr[order.charAt(i) - 'a'] = i + 1;
            }
            for (int i = 0; i < words.length - 1; i++) {
                if (!isOrdered(words[i], words[i + 1], orderArr)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isOrdered(String word1, String word2, int[] orderArr) {
            int p = 0;
            int n1 = word1.length(), n2 = word2.length();
            while (p < n1 && p < n2 && orderArr[word1.charAt(p) - 'a'] == orderArr[word2.charAt(p) - 'a']) {
                p++;
            }
            //出现字符不相等
            if (p != n1 && p != n2) {
                return orderArr[word1.charAt(p) - 'a'] < orderArr[word2.charAt(p) - 'a'];
            }
            //两个相同长度,true;不同长度，n1短为true
            return n1 == n2 || p == n1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}