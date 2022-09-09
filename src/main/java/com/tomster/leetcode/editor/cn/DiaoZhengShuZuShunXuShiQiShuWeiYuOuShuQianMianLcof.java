/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 * <p>
 * Related Topics 数组 双指针 排序 👍 259 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-09-09 12:26:42
 */
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                while (low < high && nums[low] % 2 == 1) {
                    low++;
                }
                while (low < high && nums[high] % 2 == 0) {
                    high--;
                }
                if(low<high){
                    swap(nums,low,high);
                }
            }
            return nums;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}