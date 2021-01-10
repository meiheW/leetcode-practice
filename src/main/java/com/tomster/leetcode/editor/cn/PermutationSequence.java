//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 数学 回溯算法 
// 👍 456 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-10 11:39:07
 */
public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
        String permutation = solution.getPermutation(3, 3);
        System.out.println(permutation);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String getPermutation(int n, int k) {
            int[] factorial = new int[n + 1];
            factorial[0] = 1;
            List<Integer> candidates = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
                candidates.add(i);//candidates[0] = 1
            }
            k--;//这一步很关键，减少计算
            StringBuilder sb = new StringBuilder();
            for (int i = n - 1; i >= 0; i--) {
                int index = k / factorial[i];
                sb.append(candidates.remove(index));
                k -= index * factorial[i];
            }
            return sb.toString();

        }

        /**
         * 第一个想法就是求出全排列，然后从结果集中找到第k个
         * 结果 8, 35784 运行时间超时
         *
         * @param n
         * @param k
         * @return
         */
        public String getPermutation1(int n, int k) {

            List<String> result = new ArrayList<>();
            backTrace(result, n, new ArrayList<>());
            return result.get(k - 1);

        }

        private void backTrace(List<String> result, int n, List<Integer> temp) {
            if (n == temp.size()) {
                StringBuilder sb = new StringBuilder();
                for (Integer i : temp) {
                    sb.append(i);
                }
                result.add(sb.toString());
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (temp.contains(i)) {
                    continue;
                }

                temp.add(i);
                backTrace(result, n, temp);
                temp.remove(temp.size() - 1);
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}