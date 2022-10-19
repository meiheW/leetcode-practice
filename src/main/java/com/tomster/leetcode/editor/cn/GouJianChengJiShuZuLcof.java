/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]
 * =A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * <p>
 * Related Topics 数组 前缀和 👍 272 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 08:07:45
 */
public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a == null || a.length < 1) {
                return new int[]{};
            }
            int n = a.length;
            if (n == 1) {
                return new int[]{1};
            }
            int[] leftProduct = new int[n];
            leftProduct[0] = 1;
            for (int i = 1; i < leftProduct.length; i++) {
                leftProduct[i] = leftProduct[i - 1] * a[i - 1];
            }
            int[] rightProduct = new int[n];
            rightProduct[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                rightProduct[i] = rightProduct[i + 1] * a[i + 1];
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = leftProduct[i] * rightProduct[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}