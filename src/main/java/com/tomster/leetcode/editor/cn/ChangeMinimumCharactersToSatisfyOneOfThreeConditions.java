//给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。 
//
// 操作的最终目标是满足下列三个条件 之一 ： 
//
// 
// a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。 
// b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。 
// a 和 b 都 由 同一个 字母组成。 
// 
//
// 返回达成目标所需的 最少 操作数。 
//
// 
//
// 示例 1： 
//
// 输入：a = "aba", b = "caa"
//输出：2
//解释：满足每个条件的最佳方案分别是：
//1) 将 b 变为 "ccc"，2 次操作，满足 a 中的每个字母都小于 b 中的每个字母；
//2) 将 a 变为 "bbb" 并将 b 变为 "aaa"，3 次操作，满足 b 中的每个字母都小于 a 中的每个字母；
//3) 将 a 变为 "aaa" 并将 b 变为 "aaa"，2 次操作，满足 a 和 b 由同一个字母组成。
//最佳的方案只需要 2 次操作（满足条件 1 或者条件 3）。
// 
//
// 示例 2： 
//
// 输入：a = "dabadd", b = "cda"
//输出：3
//解释：满足条件 1 的最佳方案是将 b 变为 "eee" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 105 
// a 和 b 只由小写字母组成 
// 
// Related Topics 哈希表 字符串 计数 前缀和 
// 👍 46 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-09-25 22:39:26
 */
public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
    public static void main(String[] args) {
        Solution solution = new ChangeMinimumCharactersToSatisfyOneOfThreeConditions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCharacters(String a, String b) {
            int m = a.length(), n = b.length(), res = m + n;
            int[] c1 = new int[26], c2 = new int[26];
            for (int i = 0; i < m; ++i) {
                c1[a.charAt(i) - 'a']++;
            }
            for (int i = 0; i < n; ++i) {
                c2[b.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; ++i) {
                res = Math.min(res, m + n - c1[i] - c2[i]); // condition 3
                if (i > 0) {
                    c1[i] += c1[i - 1];
                    c2[i] += c2[i - 1];
                }
                if (i < 25) {
                    res = Math.min(res, m - c1[i] + c2[i]); // condition 1
                    res = Math.min(res, n - c2[i] + c1[i]); // condition 2
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}