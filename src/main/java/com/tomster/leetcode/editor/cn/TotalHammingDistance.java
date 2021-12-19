//两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。 
//
// 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间 汉明距离的总和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,14,2]
//输出：6
//解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
//所以答案为：
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 
//2 + 2 = 6
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,14,4]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 109 
// 给定输入的对应答案符合 32-bit 整数范围 
// 
// Related Topics 位运算 数组 数学 
// 👍 239 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 12:37:04
 */
public class TotalHammingDistance {
    public static void main(String[] args) {
        Solution solution = new TotalHammingDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //位运算
        public int totalHammingDistance(int[] nums) {
            int res = 0;
            int n = nums.length;
            for (int i = 0; i < 32; i++) {
                int c = 0;
                for (int num : nums) {
                    c += (num >> i) & 1;
                }
                res += c * (n - c);
            }
            return res;
        }


        public int totalHammingDistance1(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    res += Integer.bitCount(nums[i] ^ nums[j]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}