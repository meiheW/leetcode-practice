/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以
 * 看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 * Related Topics 数组 排序 👍 277 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2022-10-16 15:46:24
 */
public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        boolean b = solution.isStraight(new int[]{1, 2, 3, 4, 5});
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int index = 0;
            while (index < 5 && nums[index] == 0) {
                index++;
            }
            int zeroCnt = index;
            int gapSum = 0;
            for (int i = index; i < 4; i++) {
                int gap = nums[i + 1] - nums[i];
                if (gap == 0) {
                    return false;
                }
                gapSum += (gap - 1);
            }
            return zeroCnt >= gapSum;
        }

        public boolean isStraight1(int[] nums) {
            Set<Integer> repeat = new HashSet<>();
            int max = 0, min = 14;
            for (int num : nums) {
                if (num == 0) continue; // 跳过大小王
                max = Math.max(max, num); // 最大牌
                min = Math.min(min, num); // 最小牌
                if (repeat.contains(num)) return false; // 若有重复，提前返回 false
                repeat.add(num); // 添加此牌至 Set
            }
            return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}