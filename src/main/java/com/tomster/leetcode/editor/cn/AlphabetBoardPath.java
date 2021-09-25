//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
// Related Topics 哈希表 字符串 
// 👍 34 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-09-25 17:29:48
 */
public class AlphabetBoardPath {
    public static void main(String[] args) {
        Solution solution = new AlphabetBoardPath().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alphabetBoardPath(String target) {
            StringBuilder sb = new StringBuilder();
            char[] chars = target.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                sb.append(pathOrder(i == 0 ? 'a' : chars[i - 1], chars[i]));
                sb.append("!");
            }
            return sb.toString();
        }

        private String pathOrder(char start, char end) {
            int vertical = (end - 'a') / 5 - (start - 'a') / 5;
            int horizontal = (end - 'a') % 5 - (start - 'a') % 5;
            char vChar = vertical > 0 ? 'D' : 'U';
            char hChar = horizontal > 0 ? 'R' : 'L';
            String vStr = createNcharStr(Math.abs(vertical), vChar);
            String hStr = createNcharStr(Math.abs(horizontal), hChar);
            return vertical > 0 ? hStr + vStr : vStr + hStr;
        }

        private String createNcharStr(int n, char ch) {
            if (n == 0) {
                return "";
            }
            char[] chars = new char[n];
            Arrays.fill(chars, ch);
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}