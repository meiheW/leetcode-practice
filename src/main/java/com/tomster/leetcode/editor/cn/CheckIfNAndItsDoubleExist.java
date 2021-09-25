//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 40 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-09-25 19:17:37
 */
public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        Solution solution = new CheckIfNAndItsDoubleExist().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 看了一个参考答案
         * 不需要排序，也不需要分符号，也是用哈希表做的
         * 表中有cur的2倍存在，或者cur是偶数且表中有其1/2存在
         * 执行耗时:1 ms,击败了98.59% 的Java用户
         * 内存消耗:38.8 MB,击败了27.43% 的Java用户
         */
        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int value : arr) {
                if (set.contains(value * 2) || (value % 2 == 0 && set.contains(value / 2))) {
                    return true;
                }
                set.add(value);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}