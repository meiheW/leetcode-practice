//给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。 
//
// 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。 
//
// 注意：子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "ababccc"
//输出：5
//解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样
//拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
// 
//
// 示例 2： 
//
// 输入：s = "aba"
//输出：2
//解释：一种最大拆分方法为 ['a', 'ba'] 。
// 
//
// 示例 3： 
//
// 输入：s = "aa"
//输出：1
//解释：无法进一步拆分字符串。
// 
//
// 
//
// 提示： 
//
// 
// 
// 1 <= s.length <= 16 
// 
// 
// s 仅包含小写英文字母 
// 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 35 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-09-26 23:30:16
 */
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    public static void main(String[] args) {
        Solution solution = new SplitAStringIntoTheMaxNumberOfUniqueSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int max = 1;

        public int maxUniqueSplit(String s) {
            Set<String> set = new HashSet<>();
            backTracing(0, 0, s, set);
            return max;
        }

        private void backTracing(int index, int num, String s, Set<String> set) {
            if (index >= s.length()) {
                max = Math.max(max, num);
            }
            for (int i = index; i < s.length(); i++) {
                String str = s.substring(index, i + 1);
                if (set.add(str)) {
                    backTracing(i + 1, num + 1, s, set);
                    set.remove(str);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}