//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。 
//
// （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。） 
//
// 示例 1: 
//
// 
//输入: L = 6, R = 10
//输出: 4
//解释:
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
// 
//
// 示例 2: 
//
// 
//输入: L = 10, R = 15
//输出: 5
//解释:
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
// 
//
// 注意: 
//
// 
// L, R 是 L <= R 且在 [1, 10^6] 中的整数。 
// R - L 的最大值为 10000。 
// 
// Related Topics 位运算 数学 
// 👍 67 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 15:57:30
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimeSetBits(int left, int right) {
            int ans = 0;
            for (int i = left; i <= right; i++) {
                if (isPrime(bitsNum(i))) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private int bitsNum(int n) {
            int num = 0;
            for (int i = 0; i < 32; i++) {
                num += (n >> i) & 1;
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}