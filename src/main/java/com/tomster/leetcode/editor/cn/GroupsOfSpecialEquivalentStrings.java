//给你一个字符串数组 words。 
//
// 一步操作中，你可以交换字符串 words[i] 的任意两个偶数下标对应的字符或任意两个奇数下标对应的字符。 
//
// 对两个字符串 words[i] 和 words[j] 而言，如果经过任意次数的操作，words[i] == words[j] ，那么这两个字符串是 特殊等
//价 的。 
//
// 
// 例如，words[i] = "zzxy" 和 words[j] = "xyzz" 是一对 特殊等价 字符串，因为可以按 "zzxy" -> "xzzy" 
//-> "xyzz" 的操作路径使 words[i] == words[j] 。 
// 
//
// 现在规定，words 的 一组特殊等价字符串 就是 words 的一个同时满足下述条件的非空子集： 
//
// 
// 该组中的每一对字符串都是 特殊等价 的 
// 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特
//殊等价） 
// 
//
// 返回 words 中 特殊等价字符串组 的数量。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
//输出：3
//解释：
//其中一组为 ["abcd", "cdab", "cbad"]，因为它们是成对的特殊等价字符串，且没有其他字符串与这些字符串特殊等价。
//另外两组分别是 ["xyzz", "zzxy"] 和 ["zzyx"]。特别需要注意的是，"zzxy" 不与 "zzyx" 特殊等价。
// 
//
// 示例 2： 
//
// 
//输入：words = ["abc","acb","bac","bca","cab","cba"]
//输出：3
//解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 20 
// 所有 words[i] 都只由小写字母组成。 
// 所有 words[i] 都具有相同的长度。 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 102 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 15:46:14
 */
public class GroupsOfSpecialEquivalentStrings {
    public static void main(String[] args) {
        Solution solution = new GroupsOfSpecialEquivalentStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSpecialEquivGroups(String[] words) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                StringBuilder odd = new StringBuilder();
                StringBuilder even = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    if (i % 2 == 0) {
                        even.append(word.charAt(i));
                    } else {
                        odd.append(word.charAt(i));
                    }
                }
                String key = "";
                if (even.length() != 0) {
                    char[] evenChar = even.toString().toCharArray();
                    Arrays.sort(evenChar);
                    key += new String(evenChar);
                }
                if (odd.length() != 0) {
                    char[] oddChar = odd.toString().toCharArray();
                    Arrays.sort(oddChar);
                    key += new String(oddChar);
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            return map.keySet().size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}