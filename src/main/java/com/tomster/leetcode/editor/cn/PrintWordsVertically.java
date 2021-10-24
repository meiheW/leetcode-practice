//给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。 
//单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。 
//每个单词只能放在一列上，每一列中也只能有一个单词。 
//
// 
//
// 示例 1： 
//
// 输入：s = "HOW ARE YOU"
//输出：["HAY","ORO","WEU"]
//解释：每个单词都应该竖直打印。 
// "HAY"
// "ORO"
// "WEU"
// 
//
// 示例 2： 
//
// 输入：s = "TO BE OR NOT TO BE"
//输出：["TBONTB","OEROOE","   T"]
//解释：题目允许使用空格补位，但不允许输出末尾出现空格。
//"TBONTB"
//"OEROOE"
//"   T"
// 
//
// 示例 3： 
//
// 输入：s = "CONTEST IS COMING"
//输出：["CIC","OSO","N M","T I","E N","S G","T"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 200 
// s 仅含大写英文字母。 
// 题目数据保证两个单词之间只有一个空格。 
// 
// Related Topics 数组 字符串 模拟 
// 👍 29 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-10-24 21:23:32
 */
public class PrintWordsVertically {
    public static void main(String[] args) {
        Solution solution = new PrintWordsVertically().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> printVertically(String s) {
            int maxLen = 0;
            String[] strArr = s.split(" ");
            for (String str : strArr) {
                maxLen = Math.max(maxLen, str.length());
            }
            int m = strArr.length, n = maxLen;
            //把字符串存进矩阵，再解析矩阵即可
            char[][] matrix = new char[m][n];
            for (int i = 0; i < m; i++) {
                System.arraycopy(strArr[i].toCharArray(), 0, matrix[i], 0, strArr[i].length());
            }
            List<String> ans = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                int i = m - 1;
                while (matrix[i][j] == '\u0000') {
                    i--;
                }
                while (i >= 0) {
                    sb.append('\u0000' == matrix[i][j] ? " " : matrix[i][j]);
                    i--;
                }
                ans.add(sb.reverse().toString());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}