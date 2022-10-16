/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * <p>
 * <p>
 * Related Topics 数学 双指针 枚举 👍 487 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-10-14 17:24:17
 */
public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int i = 1, j = 2, s = 3;
            List<int[]> res = new ArrayList<>();
            while (i < j) {
                if (s == target) {
                    int[] ans = new int[j - i + 1];
                    for (int k = i; k <= j; k++)
                        ans[k - i] = k;
                    res.add(ans);
                }
                if (s >= target) {
                    s -= i;
                    i++;
                } else {
                    j++;
                    s += j;
                }
            }
            return res.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}