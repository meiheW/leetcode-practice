//给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 3： 
//
// 输入：[1]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 4： 
//
// 输入：[1,1]
//输出：true
//解释：可行的分组是 [1,1]
// 
//
// 示例 5： 
//
// 输入：[1,1,2,2,2,2]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[2,2]
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10000 
// 0 <= deck[i] < 10000 
// 
//
// 
// Related Topics 数组 哈希表 数学 计数 数论 
// 👍 235 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 18:46:05
 */
public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        Solution solution = new XOfAKindInADeckOfCards().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 输入：[1,1,1,2,2,2,3,3]  输出：false
         * 输入：[1,1,1,1,2,2,2,2,2,2]  输出：true
         */
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int item : deck) {
                countMap.put(item, countMap.getOrDefault(item, 0) + 1);
            }
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                min = Math.min(min, entry.getValue());
            }

            int gcd = countMap.get(deck[0]);
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 1) {
                    return false;
                }
                //求所有频次的最大公约数
                gcd = gcd(gcd, entry.getValue());
                if (gcd == 1) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 最大公约数
         */
        private int gcd(int a, int b) {
            int m = Math.max(a, b);
            int n = Math.min(a, b);
            int t = m % n;
            while (t != 0) {
                m = n;
                n = t;
                t = m % n;
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}