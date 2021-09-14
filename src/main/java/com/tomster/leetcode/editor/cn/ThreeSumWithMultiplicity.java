//给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的
//元组 i, j, k 的数量。 
//
// 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
//输出：20
//解释：
//按值枚举（A[i]，A[j]，A[k]）：
//(1, 2, 5) 出现 8 次；
//(1, 3, 4) 出现 8 次；
//(2, 2, 4) 出现 2 次；
//(2, 3, 3) 出现 2 次。
// 
//
// 示例 2： 
//
// 输入：A = [1,1,2,2,2,2], target = 5
//输出：12
//解释：
//A[i] = 1，A[j] = A[k] = 2 出现 12 次：
//我们从 [1,1] 中选择一个 1，有 2 种情况，
//从 [2,2,2,2] 中选出两个 2，有 6 种情况。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 3000 
// 0 <= A[i] <= 100 
// 0 <= target <= 300 
// 
// Related Topics 数组 哈希表 双指针 计数 排序 
// 👍 82 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-09-14 18:52:50
 */
public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        Solution solution = new ThreeSumWithMultiplicity().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumMulti(int[] arr, int target) {
            long ans = 0;
            int base = (int) Math.pow(10, 9) + 7;
            int n = arr.length;
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                int t = target - arr[i];
                int low = i + 1;
                int high = n - 1;
                //2 sum
                while (low < high) {
                    if (arr[low] + arr[high] < t) {
                        low++;
                    } else if (arr[low] + arr[high] > t) {
                        high--;
                    } else if (arr[low] == arr[high]) {
                        ans += (high - low + 1) * (high - low) / 2;
                        ans %= base;
                        break;
                    } else {
                        int lc = 1, rc = 1;
                        while (low + 1 < high && arr[low + 1] == arr[low]) {
                            low++;
                            lc++;
                        }
                        while (high - 1 > low && arr[high - 1] == arr[high]) {
                            high--;
                            rc++;
                        }
                        ans += lc * rc;
                        ans %= base;

                        low++;
                        high--;
                    }
                }
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}