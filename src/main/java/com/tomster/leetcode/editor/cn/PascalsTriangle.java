//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 448 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-31 21:49:59
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if (numRows <= 0) {
                return result;
            }
            List<Integer> rowVal = new ArrayList<>();
            rowVal.add(1);
            result.add(rowVal);
            if (numRows == 1) {
                return result;
            }
            for (int row = 2; row <= numRows; row++) {
                List<Integer> curRowVal = new ArrayList<>();
                for (int i = 0; i < row; i++) {
                    if (i == 0 || i == row-1) {
                        curRowVal.add(1);
                    } else {
                        List<Integer> lastList = result.get(result.size() - 1);
                        curRowVal.add(lastList.get(i - 1) + lastList.get(i));
                    }
                }
                result.add(curRowVal);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}