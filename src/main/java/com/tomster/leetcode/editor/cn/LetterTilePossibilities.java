//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
// Related Topics 字符串 回溯 
// 👍 136 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-03-12 18:13:34
 */
public class LetterTilePossibilities {
    public static void main(String[] args) {
        Solution solution = new LetterTilePossibilities().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTilePossibilities(String tiles) {
            List<String> ans = new ArrayList<>();
            char[] tileArr = tiles.toCharArray();
            //这个排序很有必要，是为了后面判重，同47题
            Arrays.sort(tileArr);
            boolean[] used = new boolean[tileArr.length];
            backTracing(ans, new StringBuffer(), tileArr, used);
            return ans.size();
        }

        private void backTracing(List<String> ans, StringBuffer sb, char[] tileArr, boolean[] used) {
            if (sb.length() != 0) {
                ans.add(sb.toString());
            }
            for (int i = 0; i < tileArr.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && tileArr[i] == tileArr[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                sb.append(tileArr[i]);
                backTracing(ans, sb, tileArr, used);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}