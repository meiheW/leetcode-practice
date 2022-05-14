//给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。 
//
// 丑数是可以被 a 或 b 或 c 整除的 正整数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, a = 2, b = 3, c = 5
//输出：4
//解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3, c = 4
//输出：6
//解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
// 
//
// 示例 3： 
//
// 
//输入：n = 5, a = 2, b = 11, c = 13
//输出：10
//解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
// 
//
// 示例 4： 
//
// 
//输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
//输出：1999999984
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, a, b, c <= 10^9 
// 1 <= a * b * c <= 10^18 
// 本题结果在 [1, 2 * 10^9] 的范围内 
// 
// Related Topics 数学 二分查找 数论 
// 👍 107 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-05-14 15:52:08
 */
public class UglyNumberIii {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            long L1 = (long) a / gcd(a, b) * b;
            long L2 = (long) a / gcd(a, c) * c;
            long L3 = (long) c / gcd(c, b) * b;
            long LL = L1 / gcd(L1, c) * c;


            long lo = 0;
            long hi = (long) 1e15;
            while (lo < hi) {
                long mi = lo + (hi - lo) / 2;
                if (mi / a + mi / b + mi / c - mi / L1 - mi / L2 - mi / L3 + mi / LL < n) {
                    lo = mi + 1;
                } else {
                    hi = mi;
                }
            }

            return (int) lo;
        }

        public long gcd(long x, long y) {
            if (x == 0) {
                return y;
            }
            return gcd(y % x, x);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}