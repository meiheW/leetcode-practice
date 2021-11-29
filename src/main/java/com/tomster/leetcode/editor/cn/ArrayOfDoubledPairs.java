//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 示例 4： 
//
// 
//输入：arr = [1,2,4,16,8,4]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 104 
// arr.length 是偶数 
// -105 <= arr[i] <= 105 
// 
// Related Topics 贪心 数组 哈希表 排序 
// 👍 59 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-11-29 22:09:08
 */
public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //判断数组是否为2倍数对数组,元素有+有-
        public boolean canReorderDoubled(int[] arr) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int item : arr) {
                countMap.put(item, countMap.getOrDefault(item, 0) + 1);
            }
            Integer[] nums = new Integer[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = arr[i];
            }
            Arrays.sort(nums, Comparator.comparingInt(Math::abs));
            for (Integer num : nums) {
                if (countMap.get(num) == 0) {
                    continue;
                }
                if (countMap.getOrDefault(num * 2, 0) <= 0) {
                    return false;
                }
                //操作map
                countMap.put(num, countMap.get(num) - 1);
                countMap.put(num * 2, countMap.get(num * 2) - 1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}