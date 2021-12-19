//在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。 
//
// 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始） 
//
// 
//例子: 
//
// 输入: N = 1, K = 1
//输出: 0
//
//输入: N = 2, K = 1
//输出: 0
//
//输入: N = 2, K = 2
//输出: 1
//
//输入: N = 4, K = 5
//输出: 1
//
//解释:
//第一行: 0
//第二行: 01
//第三行: 0110
//第四行: 01101001
// 
//
// 
//注意： 
//
// 
// N 的范围 [1, 30]. 
// K 的范围 [1, 2^(N-1)]. 
// 
// Related Topics 位运算 递归 数学 
// 👍 143 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-19 16:05:04
 */
public class KThSymbolInGrammar {
    public static void main(String[] args) {
        Solution solution = new KThSymbolInGrammar().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 第一行: 0
         * 第二行: 01
         * 第三行: 0110
         * 第四行: 0110 1001
         * 第五行: 0110 1001 1001 0110
         * 找规律，递归，击败百分百，嘎嘎
         */
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            } else if (n == 2) {
                return k == 1 ? 0 : 1;
            }
            int num = (int) Math.pow(2, n - 1);
            if (k <= num / 2) {
                return kthGrammar(n - 1, k);
            } else if (k <= num * 3 / 4) {
                return kthGrammar(n - 1, k - num / 4);
            } else {
                return kthGrammar(n - 1, k - num * 3 / 4);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}