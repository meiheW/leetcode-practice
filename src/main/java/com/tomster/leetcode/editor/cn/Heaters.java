//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 104 
// 1 <= houses[i], heaters[i] <= 109 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 231 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-28 11:37:30
 */
public class Heaters {
    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分查找 Arrays.binarySearch
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(heaters);
            int ans = 0;
            for (int house : houses) {
                int index = Arrays.binarySearch(heaters, house);
                if (index >= 0) {
                    continue;
                }
                index = -(1 + index);
                //diff1表示和前一个的举例，diff2表示与后一个的距离
                int diff1 = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int diff2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                ans = Math.max(ans, Math.min(diff1, diff2));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}