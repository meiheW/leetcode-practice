//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 204 👎 0

package com.tomster.leetcode.editor.cn;
/**
 * @author: tomster
 * @data: 2021-05-15 13:31:51
 */
public class SortArrayByParityIi {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParityIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int[] result = new int[nums.length];
            int indexOdd = -1, indexEven = -2;
            for (int num : nums) {
                if (num % 2 == 0) {
                    result[indexEven += 2] = num;
                } else {
                    result[indexOdd += 2] = num;
                }
            }
            return result;

        }

        public int[] sortArrayByParityII2(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                //下标与数字奇偶性不一致
                if (i % 2 != nums[i] % 2) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (i % 2 == nums[j] % 2) {
                            swap(nums, i, j);
                            break;
                        }
                    }
                }
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}