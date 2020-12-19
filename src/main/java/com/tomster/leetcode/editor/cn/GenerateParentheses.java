//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1481 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2020-12-19 15:31:55
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            dfs(result, n, n, "");
            return result;
        }

        private void dfs(List<String> result, int left, int right, String s) {
            if (left == 0 && right == 0) {
                result.add(s);
                return;
            }

            if (left != 0) {
                dfs(result, left - 1, right, s + "(");
            }
            if (right > left) {
                dfs(result, left, right - 1, s + ")");
            }


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}