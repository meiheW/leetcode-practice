//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。 
// Related Topics 排序 数组 
// 👍 350 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-01-10 11:12:26
 */
public class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int i = 0;
            int len = intervals.length;
            List<int[]> res = new ArrayList<>();
            //从左到右遍历数组，区间右端点在新区间左端点左边，直接加入
            while (i < len && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i++]);
            }
            //后面处理可能重复的区间，即区间左端点在新区间右端点左边，更新新区间
            while ((i < len && intervals[i][0] <= newInterval[1])) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            res.add(newInterval);
            //新区间右边不重合的区间
            while (i < len) {
                res.add(intervals[i++]);
            }

            //List<int[]> -> int[][]
            return res.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}