//给定字符串列表 strs ，返回 它们中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。 
//
// 最长特殊序列 定义如下：该序列为某字符串 独有的最长子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"
//、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 
// 👍 91 👎 0

package com.tomster.leetcode.editor.cn;

import sun.rmi.server.UnicastRef2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2022-04-10 18:44:03
 */
public class LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            int ans = -1;
            int i = 0, j = 0;
            for (i = 0; i < strs.length; i++) {
                for (j = 0; j < strs.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (isSubSeq(strs[i], strs[j])) {
                        break;
                    }
                }
                if (j == strs.length) {
                    ans = Math.max(ans, strs[i].length());
                }
            }
            return ans;
        }

        private boolean isSubSeq(String str0, String str1) {
            if (str0.length() > str1.length()) {
                return false;
            }
            int p0 = 0, p1 = 0;
            for (p1 = 0; p0 < str0.length() && p1 < str1.length(); p1++) {
                if (str1.charAt(p1) == str0.charAt(p0)) {
                    p0++;
                }
            }
            return p0 == str0.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}