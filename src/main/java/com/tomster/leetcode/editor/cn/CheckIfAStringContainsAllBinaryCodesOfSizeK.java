//给你一个二进制字符串 s 和一个整数 k 。 
//
// 如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "00110110", k = 2
//输出：true
//解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "00110", k = 2
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "0110", k = 1
//输出：true
//解释：长度为 1 的二进制串包括 "0" 和 "1"，显然它们都是 s 的子串。
// 
//
// 示例 4： 
//
// 
//输入：s = "0110", k = 2
//输出：false
//解释：长度为 2 的二进制串 "00" 没有出现在 s 中。
// 
//
// 示例 5： 
//
// 
//输入：s = "0000000001011100", k = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 105 
// s[i] 不是'0' 就是 '1' 
// 1 <= k <= 20 
// 
// Related Topics 位运算 哈希表 字符串 哈希函数 滚动哈希 
// 👍 30 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-09-25 19:50:49
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args) {
        Solution solution = new CheckIfAStringContainsAllBinaryCodesOfSizeK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            int n = s.length();
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= n - k; i++) {
                set.add(s.substring(i, i + k));
            }
            return set.size() == (int) Math.pow(2, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}