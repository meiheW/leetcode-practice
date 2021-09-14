//国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c
//" 对应 "-.-.", 等等。 
//
// 为了方便，所有26个英文字母对应摩尔斯密码表如下： 
//
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","-
//-","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--
//.."] 
//
// 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" +
// "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。 
//
// 返回我们可以获得所有词不同单词翻译的数量。 
//
// 例如:
//输入: words = ["gin", "zen", "gig", "msg"]
//输出: 2
//解释: 
//各单词翻译如下:
//"gin" -> "--...-."
//"zen" -> "--...-."
//"gig" -> "--...--."
//"msg" -> "--...--."
//
//共有 2 种不同翻译, "--...-." 和 "--...--.".
// 
//
// 
//
// 注意: 
//
// 
// 单词列表words 的长度不会超过 100。 
// 每个单词 words[i]的长度范围为 [1, 12]。 
// 每个单词 words[i]只包含小写字母。 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 164 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashSet;

/**
 * @author: tomster
 * @data: 2021-09-14 10:09:07
 */
public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        Solution solution = new UniqueMorseCodeWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] morseList = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        public int uniqueMorseRepresentations(String[] words) {
            HashSet<String> set = new HashSet<>();
            for (String word : words) {
                set.add(wordMorse(word));
            }
            return set.size();
        }

        private String wordMorse(String word) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morseList[c - 'a']);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}