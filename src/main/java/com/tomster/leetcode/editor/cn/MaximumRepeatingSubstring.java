//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
// k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 
//为 0 。 
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
// 
//
// 示例 3： 
//
// 
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence 和 word 都只包含小写英文字母。 
// 
// Related Topics 字符串 字符串匹配 
// 👍 20 👎 0

package com.tomster.leetcode.editor.cn;

import sun.swing.StringUIClientPropertyKey;

/**
 * @author: tomster
 * @data: 2022-04-13 12:47:04
 */
public class MaximumRepeatingSubstring {
    public static void main(String[] args) {
        Solution solution = new MaximumRepeatingSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：sequence = "ababc", word = "ab"
        //输出：2
        public int maxRepeating(String sequence, String word) {
            StringBuilder sb = new StringBuilder();
            int ans = 0;
            /*do {
                sb.append(word);
                ans++;
            } while (sequence.contains(sb));
            return ans - 1;*/
            sb.append(word);
            while (sequence.contains(sb)) {
                sb.append(word);
                ans++;
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}