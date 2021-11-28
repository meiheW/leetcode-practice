//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 104 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 
// 👍 106 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tomster
 * @data: 2021-11-28 11:45:39
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int n = timePoints.size();
            List<Integer> list = timePoints.stream().map(e -> {
                String[] split = e.split(":");
                return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            }).sorted().collect(Collectors.toList());
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                ans = Math.min(ans, list.get(i + 1) - list.get(i));
                if (ans == 0) {
                    return 0;
                }
            }
            return Math.min(ans, 24 * 60 - list.get(n - 1) + list.get(0));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}