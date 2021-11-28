//有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。 
//
// 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。 
//
// 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。 
//
// 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。 
//
// 我们能得到的最大收益是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//输出: 100 
//解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。 
//
// 示例 2: 
//
// 
//输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
//输出: 0 
//
// 
//
// 提示: 
//
// 
// n == difficulty.length 
// n == profit.length 
// m == worker.length 
// 1 <= n, m <= 104 
// 1 <= difficulty[i], profit[i], worker[i] <= 105 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 69 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: tomster
 * @data: 2021-11-28 14:05:32
 */
public class MostProfitAssigningWork {
    public static void main(String[] args) {
        Solution solution = new MostProfitAssigningWork().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;
            int[][] diffProfit = new int[n][2];
            for (int i = 0; i < n; i++) {
                diffProfit[i][0] = difficulty[i];
                diffProfit[i][1] = profit[i];
            }
            Arrays.sort(diffProfit, (o1, o2) -> o1[1] != o2[1] ? Integer.compare(o1[1], o2[1])
                    : Integer.compare(o1[0], o2[0]));
            int ans = 0;
            for (int i : worker) {
                for (int j = n - 1; j >= 0; j--) {
                    if (diffProfit[j][0] <= i) {
                        ans += diffProfit[j][1];
                        break;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}