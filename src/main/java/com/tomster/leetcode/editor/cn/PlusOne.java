//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 612 👎 0

package com.tomster.leetcode.editor.cn;
/**
 * @author: tomster
 * @data: 2021-01-09 01:18:38
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        //从后往前找到第一个不是9的数字
        int index = digits.length - 1;
        while (index != -1 && digits[index] == 9) {
            index--;
        }
        if (index == -1) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = 0;
            }
            return result;
        } else {
            digits[index] += 1;
            for (int i = index + 1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}