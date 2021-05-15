//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 321 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2021-05-15 13:25:55
 */
public class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
        String aabbc = solution.reorganizeString("aaabbbc");
        System.out.println(aabbc);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String s) {

            int[] charCount = new int[26];
            char[] chars = s.toCharArray();
            int maxCount = 0;
            for (char c : chars) {
                charCount[c - 'a']++;
                maxCount = Math.max(maxCount, charCount[c - 'a']);
            }
            //不能使相同的字符完全隔开
            if (maxCount > (s.length() + 1) / 2) {
                return "";
            }
            //最大堆
            PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> charCount[o2 - 'a'] - charCount[o1 - 'a']);
            for (char c = 'a'; c <= 'z'; c++) {
                if (charCount[c - 'a'] != 0) {
                    pq.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (pq.size() > 1) {
                Character peek1 = pq.poll();
                Character peek2 = pq.poll();
                sb.append(peek1).append(peek2);
                int index1 = peek1 - 'a', index2 = peek2 - 'a';
                charCount[index1]--;
                charCount[index2]--;
                if (charCount[index1] > 0) {
                    pq.add(peek1);
                }
                if (charCount[index2] > 0) {
                    pq.add(peek2);
                }
            }
            if (pq.size() != 0) {
                sb.append(pq.poll());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}