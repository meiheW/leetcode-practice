/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * Related Topics 字符串 回溯 👍 608 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2022-09-12 12:24:24
 */
public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            boolean[] used = new boolean[s.length()];
            backTracing(set, sb, s, used);
            String[] ans = new String[set.size()];
            Iterator<String> iterator = set.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                ans[i++] = iterator.next();
            }
            return ans;
        }

        private void backTracing(Set<String> ans, StringBuilder sb, String s,
                                 boolean[] used) {
            if (sb.length() == s.length()) {
                ans.add(sb.toString());
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    sb.append(s.charAt(i));
                    backTracing(ans, sb, s, used);
                    sb.deleteCharAt(sb.length() - 1);
                    used[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}