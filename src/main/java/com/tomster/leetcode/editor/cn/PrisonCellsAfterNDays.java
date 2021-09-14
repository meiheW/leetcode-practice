//8 间牢房排成一排，每间牢房不是有人住就是空着。 
//
// 每天，无论牢房是被占用或空置，都会根据以下规则进行更改： 
//
// 
// 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。 
// 否则，它就会被空置。 
// 
//
// （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。） 
//
// 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。 
//
// 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：cells = [0,1,0,1,1,0,0,1], N = 7
//输出：[0,0,1,1,0,0,0,0]
//解释：
//下表概述了监狱每天的状况：
//Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//
// 
//
// 示例 2： 
//
// 输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
//输出：[0,0,1,1,1,1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// cells.length == 8 
// cells[i] 的值为 0 或 1 
// 1 <= N <= 10^9 
// 
// Related Topics 位运算 数组 哈希表 数学 
// 👍 102 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 20:02:45
 */
public class PrisonCellsAfterNDays {
    public static void main(String[] args) {
        Solution solution = new PrisonCellsAfterNDays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：cells = [0,1,0,1,1,0,0,1], N = 7
        //输出：[0,0,1,1,0,0,0,0]
        public int[] prisonAfterNDays(int[] cells, int n) {
            Map<Integer, Integer> seen = new HashMap<>();
            int state = 0;
            for (int i = 0; i < 8; i++) {
                if (cells[i] > 0) {
                    state ^= 1 << i;
                }
            }
            while (n > 0) {
                //over circle
                if (seen.containsKey(state)) {
                    n %= seen.get(state) - n;
                }
                seen.put(state, n);
                if (n >= 1) {
                    n--;
                    state = nextState(state);
                }
            }
            int[] ans = new int[8];
            for (int i = 0; i < 8; i++) {
                if ((state & (1 << i)) > 0) {
                    ans[i] = 1;
                }
            }
            return ans;
        }

        private int nextState(int state) {
            int nextState = 0;
            for (int i = 1; i <= 6; i++) {
                if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                    nextState ^= 1 << i;
                }
            }
            return nextState;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}