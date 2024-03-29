//单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足： 
//
// 
// words.length == indices.length 
// 助记字符串 s 以 '#' 字符结尾 
// 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 wor
//ds[i] 相等 
// 
//
// 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["time", "me", "bell"]
//输出：10
//解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
//words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
//words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
//words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
// 
//
// 示例 2： 
//
// 
//输入：words = ["t"]
//输出：2
//解释：一组有效编码为 s = "t#" 和 indices = [0] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// words[i] 仅由小写字母组成 
// 
// Related Topics 字典树 数组 哈希表 字符串 
// 👍 244 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-09-14 10:18:50
 */
public class ShortEncodingOfWords {
    public static void main(String[] args) {
        Solution solution = new ShortEncodingOfWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            int n = words.length - 1;
            Set<String> set = new HashSet<>();
            for (int i = n; i >= 0; i--) {
                String word = new StringBuilder(words[i]).reverse().toString();
                if (set.isEmpty()) {
                    set.add(word);
                } else {
                    boolean contain = false;
                    for (String s : set) {
                        if (s.startsWith(word)) {
                            contain = true;
                            break;
                        }
                    }
                    if (!contain) {
                        set.add(word);
                    }
                }
            }
            int ans = 0;
            for (String s : set) {
                ans += s.length();
            }
            return ans + set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}