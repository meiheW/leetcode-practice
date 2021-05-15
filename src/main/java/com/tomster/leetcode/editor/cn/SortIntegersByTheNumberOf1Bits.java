//给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。 
//
// 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [0,1,2,3,4,5,6,7,8]
//输出：[0,1,2,4,8,3,5,6,7]
//解释：[0] 是唯一一个有 0 个 1 的数。
//[1,2,4,8] 都有 1 个 1 。
//[3,5,6] 有 2 个 1 。
//[7] 有 3 个 1 。
//按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
// 
//
// 示例 2： 
//
// 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
//输出：[1,2,4,8,16,32,64,128,256,512,1024]
//解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
// 
//
// 示例 3： 
//
// 输入：arr = [10000,10000]
//输出：[10000,10000]
// 
//
// 示例 4： 
//
// 输入：arr = [2,3,5,7,11,13,17,19]
//输出：[2,3,5,17,7,11,13,19]
// 
//
// 示例 5： 
//
// 输入：arr = [10,100,1000,10000]
//输出：[10,100,10000,1000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 500 
// 0 <= arr[i] <= 10^4 
// 
// Related Topics 排序 位运算 
// 👍 105 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-05-15 15:56:19
 */
public class SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new SortIntegersByTheNumberOf1Bits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortByBits(int[] arr) {

            List<Integer> list = new ArrayList<>();
            int[] bitArr = new int[10001];
            for (int value : arr) {
                list.add(value);
                bitArr[value] = bitNum(value);
            }

            list.sort((o1, o2) -> bitArr[o1] == bitArr[o2] ? Integer.compare(o1, o2) : bitArr[o1] - bitArr[o2]);

            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
            return arr;

        }

        private int bitNum(int v) {
            int result = 0;
            while (v != 0) {
                result += v % 2;
                v /= 2;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}