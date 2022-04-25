//我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。 
//
// 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。 
//
// 
//
// 示例 1： 
//
// 输出：low = 100, high = 300
//输出：[123,234]
// 
//
// 示例 2： 
//
// 输出：low = 1000, high = 13000
//输出：[1234,2345,3456,4567,5678,6789,12345]
// 
//
// 
//
// 提示： 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics 枚举 
// 👍 40 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-04-25 17:15:28
 */
public class SequentialDigits {
    public static void main(String[] args) {
        Solution solution = new SequentialDigits().new Solution();
        List<Integer> ans = solution.sequentialDigits(100, 300);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            int cLow = getCount(low), cHigh = getCount(high);
            List<Integer> ans = new ArrayList<>();
            List<Integer> sequentialLow = getSequentialByNum(cLow);
            for (int i = 0; i < sequentialLow.size(); i++) {
                if (sequentialLow.get(i) >= low && sequentialLow.get(i) <= high) {
                    ans.add(sequentialLow.get(i));
                }
            }
            for (int i = cLow + 1; i <= cHigh - 1; i++) {
                ans.addAll(getSequentialByNum(i));
            }
            if (cLow != cHigh && cHigh != 10) {
                List<Integer> sequentialHigh = getSequentialByNum(cHigh);
                for (int i = 0; i < sequentialHigh.size(); i++) {
                    if (sequentialHigh.get(i) <= high) {
                        ans.add(sequentialHigh.get(i));
                    }
                }
            }
            return ans;
        }

        private int getCount(int low) {
            int cnt = 0;
            while (low > 0) {
                low /= 10;
                cnt++;
            }
            return cnt;
        }

        /**
         * @param num 3
         * @return 123 234 345 ... 789
         */
        private List<Integer> getSequentialByNum(int num) {
            num = Math.min(num, 9);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= num; i++) {
                sb.append(i);
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(Integer.valueOf(sb.toString()));
            for (int i = num + 1; i <= 9; i++) {
                sb.append(i);
                sb.deleteCharAt(0);
                ans.add(Integer.valueOf(sb.toString()));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}