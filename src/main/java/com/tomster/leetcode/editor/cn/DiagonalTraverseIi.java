//给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,4,2,7,5,3,8,6,9]
// 
//
// 示例 2： 
//
// 
//
// 输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
//输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
// 
//
// 示例 3： 
//
// 输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
//输出：[1,4,2,5,3,8,6,9,7,10,11]
// 
//
// 示例 4： 
//
// 输入：nums = [[1,2,3,4,5,6]]
//输出：[1,2,3,4,5,6]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i].length <= 10^5 
// 1 <= nums[i][j] <= 10^9 
// nums 中最多有 10^5 个数字。 
// 
// Related Topics 排序 数组 
// 👍 42 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-05-15 19:50:34
 */
public class DiagonalTraverseIi {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverseIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int m = nums.size();
            int n = 0;
            int itemNum = 0;
            for (List<Integer> num : nums) {
                itemNum += num.size();
                n = Math.max(n, num.size());
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < nums.get(i).size(); j++) {
                    int cur = nums.get(i).get(j);
                    List<Integer> list = map.get(i + j);
                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(cur);
                        map.put(i + j, list);
                    } else {
                        list.add(cur);
                    }
                }
            }
            int index = 0;
            int[] result = new int[itemNum];
            for (int i = 0; i <= m + n - 2; i++) {
                List<Integer> list = map.get(i);
                if (list == null) {
                    continue;
                }
                Collections.reverse(list);
                for (Integer item : list) {
                    result[index++] = item;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}