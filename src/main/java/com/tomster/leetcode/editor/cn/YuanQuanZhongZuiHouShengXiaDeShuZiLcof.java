/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * Related Topics 递归 数学 👍 697 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2022-10-16 16:03:17
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        int i = solution.lastRemaining(5, 3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            return (m + x) % n;
        }

        //模拟超时
        public int lastRemaining1(int n, int m) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int index = 0;
            while (list.size() > 1) {
                int len = list.size();
                index = (index + m - 1) % len;
                list.remove(index);
                if (index == list.size()) {
                    index = 0;
                }
            }
            return list.get(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}