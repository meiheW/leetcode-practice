//给你一个字符串 word ，该字符串由数字和小写英文字母组成。 
//
// 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123 34 8 34" 。注意，剩下的这些整数为（相邻彼此至少有
//一个空格隔开）："123"、"34"、"8" 和 "34" 。 
//
// 返回对 word 完成替换后形成的 不同 整数的数目。 
//
// 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "a123bc34d8ef34"
//输出：3
//解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
// 
//
// 示例 2： 
//
// 
//输入：word = "leet1234code234"
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：word = "a1b01c001"
//输出：1
//解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 1000 
// word 由数字和小写英文字母组成 
// 
// Related Topics 哈希表 字符串 
// 👍 16 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-09-25 22:54:36
 */
public class NumberOfDifferentIntegersInAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfDifferentIntegersInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDifferentIntegers(String word) {
            boolean started = false;
            int start = 0;
            List<String> numList = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                boolean isDigit = Character.isDigit(c);
                //未开始记录
                if (!started) {
                    //是数字，开始记录，记录开头
                    if (isDigit) {
                        started = true;
                        start = i;
                    }
                } else {
                    //开始记录
                    //不是数字，关闭记录，取出数字字符串
                    if (!isDigit) {
                        started = false;
                        numList.add(word.substring(start, i));
                    }
                }
            }
            if (started) {
                numList.add(word.substring(start));
            }

            return numList2Set(numList).size();
        }

        private Set<String> numList2Set(List<String> numList) {
            Set<String> set = new HashSet<>();
            for (String s : numList) {
                int p = 0;
                while (p < s.length() - 1 && s.charAt(p) == '0') {
                    p++;
                }
                set.add(s.substring(p));
            }
            return set;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}