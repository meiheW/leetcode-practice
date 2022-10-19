/**
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/
 * Related Topics 字符串 动态规划 👍 71 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 14:47:00
 */
public class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int ans = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                ans += count(s, i, i);
                ans += count(s, i, i + 1);
            }
            ++ans;
            return ans;
        }

        private int count(String s, int i, int j) {
            int cnt = 0;
            while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
                cnt++;
                i--;
                j++;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}