//给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。 
//
// 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。 
//
// 回文 是正着读和反着读一样的字符串。 
//
// 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的一个子序列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabca"
//输出：3
//解释：长度为 3 的 3 个回文子序列分别是：
//- "aba" ("aabca" 的子序列)
//- "aaa" ("aabca" 的子序列)
//- "aca" ("aabca" 的子序列)
// 
//
// 示例 2： 
//
// 
//输入：s = "adc"
//输出：0
//解释："adc" 不存在长度为 3 的回文子序列。
// 
//
// 示例 3： 
//
// 
//输入：s = "bbcbaba"
//输出：4
//解释：长度为 3 的 4 个回文子序列分别是：
//- "bbb" ("bbcbaba" 的子序列)
//- "bcb" ("bbcbaba" 的子序列)
//- "bab" ("bbcbaba" 的子序列)
//- "aba" ("bbcbaba" 的子序列)
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 105 
// s 仅由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 前缀和 
// 👍 10 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-09-25 23:13:57
 */
public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        Solution solution = new UniqueLength3PalindromicSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPalindromicSubsequence(String s) {
            int[] first = new int[26];
            int[] last = new int[26];
            Arrays.fill(first, -1);
            Arrays.fill(last, -1);
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (first[arr[i] - 'a'] == -1) {
                    first[arr[i] - 'a'] = i;
                }
                last[arr[i] - 'a'] = i;
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                int firstIndex = first[i];
                int lastIndex = last[i];
                //首末出现的下标中间至少相差2
                if (firstIndex != -1 && lastIndex - firstIndex > 1) {
                    Set<Character> set = new HashSet<>();
                    for (int j = firstIndex + 1; j < lastIndex; j++) {
                        set.add(arr[j]);
                    }
                    ans += set.size();
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}