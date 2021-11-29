//学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。 
//
// 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。 
//
// 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。 
//
// 返回满足 heights[i] != expected[i] 的 下标数量 。 
//
// 
//
// 示例： 
//
// 
//输入：heights = [1,1,4,2,1,3]
//输出：3 
//解释：
//高度：[1,1,4,2,1,3]
//预期：[1,1,1,2,3,4]
//下标 2 、4 、5 处的学生高度不匹配。 
//
// 示例 2： 
//
// 
//输入：heights = [5,1,2,3,4]
//输出：5
//解释：
//高度：[5,1,2,3,4]
//预期：[1,2,3,4,5]
//所有下标的对应学生高度都不匹配。 
//
// 示例 3： 
//
// 
//输入：heights = [1,2,3,4,5]
//输出：0
//解释：
//高度：[1,2,3,4,5]
//预期：[1,2,3,4,5]
//所有下标的对应学生高度都匹配。 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <= 100 
// 1 <= heights[i] <= 100 
// 
// Related Topics 数组 计数排序 排序 
// 👍 90 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-29 22:44:53
 */
public class HeightChecker {
    public static void main(String[] args) {
        Solution solution = new HeightChecker().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        final int N = 100;
        //计数排序
        public int heightChecker(int[] heights) {
            int[] count = new int[N + 1];
            for (int height : heights) {
                count[height]++;
            }
            int ans = 0;
            int index = 0;
            for (int height = 1; height <= N; height++) {
                while (count[height]-- > 0) {
                    if (height != heights[index++]) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}