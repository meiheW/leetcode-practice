/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * s.length <= 40000
 * <p>
 * <p>
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
 * repeating-characters/
 * Related Topics 哈希表 字符串 滑动窗口 👍 495 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2022-09-12 15:20:14
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        int n = solution.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。*/
        public int lengthOfLongestSubstring(String s) {
            char[] arr = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int max = 0;
            int p = 0;
            for (int i = 0; i < arr.length; i++) {
                int index = p;
                while (index < i && arr[index] != arr[i]) {
                    index++;
                }
                if (index != i) {
                    p = index + 1;
                }
                max = Math.max(max, i - p + 1);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}