//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 221 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-31 22:05:48
 */
public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>(rowIndex+1);
            for (int row = 0; row <= rowIndex; row++) {
                if (result.size() < 2) {
                    result.add(1);
                } else {
                    //从第三行开始,逆序赋值
                    for (int i = result.size() - 1; i >= 1; i--) {
                        result.set(i, result.get(i) + result.get(i - 1));
                    }
                    result.add(1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}