//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 哈希表 
// 👍 366 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-12 19:34:26
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, List<Integer>> countMap = new HashMap<>();
            int degree = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                countMap.computeIfAbsent(num, k -> new ArrayList<>());
                List<Integer> indexList = countMap.get(num);
                indexList.add(i);
                //求数组的度
                if (indexList.size() > degree) {
                    degree = indexList.size();
                }
            }
            int result = nums.length;
            for (Map.Entry<Integer, List<Integer>> entry : countMap.entrySet()) {
                List<Integer> indexList = entry.getValue();
                //等于度的数，区间的最小值
                if (indexList.size() == degree) {
                    result = Math.min(result, indexList.get(indexList.size() - 1) - indexList.get(0) + 1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}