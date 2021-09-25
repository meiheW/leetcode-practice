//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d
// 都是 nums 中的元素，且 a != b != c != d 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,6]
//输出：8
//解释：存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,5,10]
//输出：16
//解释：存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,3,4,6,8,12]
//输出：40
// 
//
// 示例 4： 
//
// 
//输入：nums = [2,3,5,7]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 104 
// nums 中的所有元素 互不相同 
// 
// Related Topics 数组 哈希表 
// 👍 13 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 17:48:00
 */
public class TupleWithSameProduct {
    public static void main(String[] args) {
        Solution solution = new TupleWithSameProduct().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            int ans = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int product = nums[i] * nums[j];
                    if (countMap.containsKey(product)) {
                        ans += countMap.get(product);
                    }
                    countMap.put(product, countMap.getOrDefault(product, 0) + 1);
                }
            }
            return ans * 8;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}