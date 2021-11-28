//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 数组 排序 
// 👍 56 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-28 15:37:19
 */
public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        Solution solution = new RemoveCoveredIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            //区间问题，左端点升序，右端点降序
            Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0]
                    ? Integer.compare(o1[0], o2[0])
                    : Integer.compare(o2[1], o1[1]));
            //int start = intervals[0][0];
            int end = intervals[0][1];
            int n = intervals.length;
            int rm = 0;
            for (int i = 1; i < n; i++) {
                int[] interval = intervals[i];
                if (interval[1] <= end) {
                    rm++;
                } else {
                    //start = interval[0];
                    end = interval[1];
                }
            }
            return n - rm;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}