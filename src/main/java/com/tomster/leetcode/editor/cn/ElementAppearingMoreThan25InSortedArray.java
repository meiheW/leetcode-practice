//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。 
//
// 请你找到并返回这个整数 
//
// 
//
// 示例： 
//
// 
//输入：arr = [1,2,2,6,6,6,6,7,10]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 0 <= arr[i] <= 10^5 
// 
// Related Topics 数组 
// 👍 57 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-04-25 17:06:52
 */
public class ElementAppearingMoreThan25InSortedArray {
    public static void main(String[] args) {
        Solution solution = new ElementAppearingMoreThan25InSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSpecialInteger(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - n / 4; i++) {
                if (arr[i] == arr[i + n / 4]) {
                    return arr[i];
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}