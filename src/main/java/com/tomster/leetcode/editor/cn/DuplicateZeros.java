//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 双指针 
// 👍 99 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-25 23:23:53
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        Solution solution = new DuplicateZeros().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int zeroCount = 0;
            for (int i : arr) {
                if (i == 0) {
                    zeroCount++;
                }
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] != 0) {
                    //不为0直接覆盖
                    if (i + zeroCount < arr.length) {
                        arr[i + zeroCount] = arr[i];
                    }
                } else {
                    //为0考虑计数变化
                    zeroCount--;
                    if (i + zeroCount < arr.length) {
                        arr[i + zeroCount] = 0;
                    }
                    if (i + zeroCount + 1 < arr.length) {
                        arr[i + zeroCount + 1] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}