//爱丽丝有一手（hand）由整数数组给定的牌。 
//
// 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。 
//
// 如果她可以完成分组就返回 true，否则返回 false。 
//
// 
//
// 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-co
//nsecutive-numbers/ 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
//输出：true
//解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。 
//
// 示例 2： 
//
// 
//输入：hand = [1,2,3,4,5], W = 4
//输出：false
//解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。 
//
// 
//
// 提示： 
//
// 
// 1 <= hand.length <= 10000 
// 0 <= hand[i] <= 10^9 
// 1 <= W <= hand.length 
// 
// Related Topics 贪心 数组 哈希表 排序 
// 👍 109 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.TreeMap;

/**
 * @author: tomster
 * @data: 2021-09-14 11:04:04
 */
public class HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new HandOfStraights().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {

            TreeMap<Integer, Integer> countMap = new TreeMap<>();
            for (int item : hand) {
                countMap.put(item, countMap.getOrDefault(item, 0) + 1);
            }
            while (!countMap.isEmpty()) {
                Integer first = countMap.firstKey();
                for (int i = 0; i < groupSize; i++) {
                    int cur = first + i;
                    if (!countMap.containsKey(cur)) {
                        return false;
                    }
                    Integer count = countMap.get(cur);
                    if (count == 1) {
                        countMap.remove(cur);
                    } else {
                        countMap.replace(cur, count - 1);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}