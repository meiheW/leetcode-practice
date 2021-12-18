//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -106 <= nums[i] <= 106 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 104 次 reset 和 shuffle 
// 
// Related Topics 数组 数学 随机化 
// 👍 245 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Random;

/**
 * @author: tomster
 * @data: 2021-12-18 22:41:55
 */
public class ShuffleAnArray {
    public static void main(String[] args) {
        //Solution solution = new ShuffleAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int n;
        int[] origin;
        int[] arr;
        Random random;

        public Solution(int[] nums) {
            n = nums.length;
            origin = new int[n];
            arr = nums;
            System.arraycopy(arr, 0, origin, 0, n);
            random = new Random();
        }

        public int[] reset() {
            System.arraycopy(origin, 0, arr, 0, n);
            return arr;
        }

        public int[] shuffle() {
            for (int i = n - 1; i > 0; i--) {
                swap(arr, i, random.nextInt(i + 1));
            }
            return arr;
        }

        private void swap(int[] arr, int m, int n) {
            int temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}