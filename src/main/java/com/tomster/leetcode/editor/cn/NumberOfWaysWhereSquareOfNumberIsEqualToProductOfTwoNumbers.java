//给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）： 
//
// 
// 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.len
//gth 且 0 <= j < k < nums2.length 
// 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.len
//gth 且 0 <= j < k < nums1.length 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [7,4], nums2 = [5,2,8,9]
//输出：1
//解释：类型 1：(1,1,2), nums1[1]^2 = nums2[1] * nums2[2] (4^2 = 2 * 8) 
//
// 示例 2： 
//
// 输入：nums1 = [1,1], nums2 = [1,1,1]
//输出：9
//解释：所有三元组都符合题目要求，因为 1^2 = 1 * 1
//类型 1：(0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2), nums1[i]^2 = nums2[
//j] * nums2[k]
//类型 2：(0,0,1), (1,0,1), (2,0,1), nums2[i]^2 = nums1[j] * nums1[k]
// 
//
// 示例 3： 
//
// 输入：nums1 = [7,7,8,3], nums2 = [1,2,9,7]
//输出：2
//解释：有两个符合题目要求的三元组
//类型 1：(3,0,2), nums1[3]^2 = nums2[0] * nums2[2]
//类型 2：(3,0,1), nums2[3]^2 = nums1[0] * nums1[1]
// 
//
// 示例 4： 
//
// 输入：nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
//输出：0
//解释：不存在符合题目要求的三元组
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 1 <= nums1[i], nums2[i] <= 10^5 
// 
// Related Topics 数组 哈希表 数学 双指针 
// 👍 10 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 22:10:23
 */
public class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTriplets(int[] nums1, int[] nums2) {
            return calcNum(nums1, nums2) + calcNum(nums2, nums1);
        }

        private int calcNum(int[] nums1, int[] nums2) {
            Map<Long, Long> countMap = new HashMap<>();
            for (long num1 : nums1) {
                countMap.put(num1, countMap.getOrDefault(num1, 0L) + 1);
            }

            Map<Long, Long> productMap = new HashMap<>();
            for (int i = 0; i < nums2.length - 1; i++) {
                for (int j = i + 1; j < nums2.length; j++) {
                    long product = (long) nums2[i] * nums2[j];
                    productMap.put(product, productMap.getOrDefault(product, 0L) + 1);
                }
            }
            int ans = 0;
            for (Map.Entry<Long, Long> entry : countMap.entrySet()) {
                long product = entry.getKey() * entry.getKey();
                if (productMap.containsKey(product)) {
                    ans += productMap.get(product) * entry.getValue();
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}