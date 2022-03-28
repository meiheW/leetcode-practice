//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 458 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-01-03 21:17:04
 */
public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 验证这个二维数组是否有效，规则如下：
         * 每一行包括1-9，不能有重复
         * 每一列包括1-9，不能有重复
         * 每一个特定3*3网格包括1-9，不能有重复
         *
         * @param board
         * @return
         */
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] columns = new int[9][9];
            int[][][] subboxes = new int[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int index = c - '0' - 1;
                        rows[i][index]++;
                        columns[j][index]++;
                        subboxes[i / 3][j / 3][index]++;
                        if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }


        //我的回答
        public boolean isValidSudoku1(char[][] board) {
            //判断每一行
            for (int i = 0; i < 9; i++) {
                Map<Character, Integer> mapRow = new HashMap<>();
                for (int j = 0; j < 9; j++) {
                    Character c = board[i][j];
                    Integer integer = mapRow.get(c);
                    if (integer != null) {
                        return false;
                    } else if (c != '.') {
                        mapRow.put(c, 1);
                    }

                }
            }

            //判断每一列
            for (int i = 0; i < 9; i++) {
                Map<Character, Integer> mapCol = new HashMap<>();
                for (int j = 0; j < 9; j++) {
                    Character c = board[j][i];
                    Integer integer = mapCol.get(c);
                    if (integer != null) {
                        return false;
                    } else if (c != '.') {
                        mapCol.put(c, 1);
                    }

                }
            }

            //判断每一个网格
            for (int i = 1; i <= 7; i += 3) {
                for (int j = 1; j <= 7; j += 3) {
                    Map<Character, Integer> mapSquare = new HashMap<>();
                    for (int p = -1; p <= 1; p++) {
                        for (int q = -1; q <= 1; q++) {
                            char c = board[i + p][j + q];
                            Integer integer = mapSquare.get(c);
                            if (integer != null) {
                                return false;
                            } else if (c != '.') {
                                mapSquare.put(c, 1);
                            }
                        }
                    }


                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}