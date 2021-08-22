//给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。 
//
// 
//
// 进阶： 
//
// 
// 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题? 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,0,1]
//输出：2
//解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：2
//解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 3： 
//
// 
//输入：nums = [9,6,4,2,3,5,7,0,1]
//输出：8
//解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 4： 
//
// 
//输入：nums = [0]
//输出：1
//解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// 0 <= nums[i] <= n 
// nums 中的所有数字都 独一无二 
// 
// Related Topics 位运算 数组 哈希表 数学 排序 
// 👍 439 👎 0

package com.tomster.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author: tomster
 * @data: 2021-08-22 15:06:55
 */
public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 0-n中的n个数，求缺失的哪个数
         * 输入：9,6,4,2,3,5,7,0,1]
         * 输出：8
         */
        public int missingNumber(int[] nums) {
            int p = 0;
            int n = nums.length;
            while (p < n) {
                while (nums[p] != n && nums[p] != p) {
                    swap(nums, p, nums[p]);
                }
                p++;
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return n;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}