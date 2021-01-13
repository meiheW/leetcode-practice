//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 466 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-13 23:32:46
 */
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            backTrace(result, temp, n, k, 1);
            return result;
        }

        private void backTrace(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
            if (temp.size() == k) {
                result.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i <= n; i++) {
                if (temp.size() + n - i + 1 < k) {
                    break;
                }
                temp.add(i);
                backTrace(result, temp, n, k, i + 1);
                temp.remove(temp.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}