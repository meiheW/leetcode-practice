//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 哈希表 计数 
// 👍 127 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 17:27:39
 */
public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfEquivalentDominoPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numEquivDominoPairs1(int[][] dominoes) {
            Map<String, Integer> countMap = new HashMap<>();
            int ans = 0;
            for (int[] dominoe : dominoes) {
                int max = Math.max(dominoe[0], dominoe[1]);
                int min = Math.min(dominoe[0], dominoe[1]);
                String str = min + "," + max;
                if (countMap.containsKey(str)) {
                    ans += countMap.get(str);
                }
                countMap.put(str, countMap.getOrDefault(str, 0) + 1);
            }
            return ans;
        }

        /**
         * 官方回答：用的是整数，本质是一样的
         * 如果数的范围不是1到9就不对了
         */
        public int numEquivDominoPairs(int[][] dominoes) {
            int[] num = new int[100];
            int ret = 0;
            for (int[] domino : dominoes) {
                int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
                ret += num[val];
                num[val]++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}