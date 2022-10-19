/**
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小
 * 写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-
 * lengths/
 * Related Topics 位运算 数组 字符串 👍 114 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 09:22:19
 */
public class AseY1I {
    public static void main(String[] args) {
        Solution solution = new AseY1I().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //位运算，字符存储
        public int maxProduct(String[] words) {
            if (words == null || words.length <= 1) {
                return 0;
            }
            int n = words.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                for (char c : words[i].toCharArray()) {
                    arr[i] |= (1 << (c - 'a'));
                }
            }
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((arr[i] & arr[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}