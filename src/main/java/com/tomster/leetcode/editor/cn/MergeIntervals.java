//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 752 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tomster
 * @data: 2021-01-09 11:40:48
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Span implements Comparable {
            int begin;
            int end;

            public Span(Span s) {
                this.begin = s.begin;
                this.end = s.end;
            }

            public Span(int begin, int end) {
                this.begin = begin;
                this.end = end;
            }

            @Override
            public int compareTo(Object o) {
                return this.begin - ((Span) o).begin;
            }
        }

        /**
         * 然后想了这种方法，先对区间元素排序，然后下一个和当前比较
         * 如果不相交，就将当前保存；相交就合并，包含就忽略下一个元素
         * 这种方法是可行的，而且容易理解，要认识到排序的重要性
         * 方法耗时较多，但是消耗内存很少
         * 解答成功: 执行耗时:10 ms,击败了9.11% 的Java用户 内存消耗:40.9 MB,击败了99.33% 的Java用户
         *
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {

            if (intervals == null || intervals.length == 1) {
                return intervals;
            }
            List<Span> resultList = new ArrayList<>();
            //对区间根据起点排序
            List<Span> spanList = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                spanList.add(new Span(intervals[i][0], intervals[i][1]));
            }
            spanList = spanList.stream().sorted().collect(Collectors.toList());
            Span curSpan = spanList.get(0);
            for (int i = 1; i < spanList.size(); i++) {
                Span nextSpan = spanList.get(i);
                if (nextSpan.begin > curSpan.end) {
                    //下一个与当前不相交，保存当前
                    resultList.add(new Span(curSpan));
                    curSpan = nextSpan;
                } else if (nextSpan.end > curSpan.end) {
                    //下一个与当前相交，当前end后移
                    curSpan.end = nextSpan.end;
                }
            }
            resultList.add(curSpan);

            int[][] result = new int[resultList.size()][2];
            for (int i = 0; i < resultList.size(); i++) {
                result[i][0] = resultList.get(i).begin;
                result[i][1] = resultList.get(i).end;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}