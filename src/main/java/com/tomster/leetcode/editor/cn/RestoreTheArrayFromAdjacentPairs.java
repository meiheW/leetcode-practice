//存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。 
//
// 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui
// 和 vi 在 nums 中相邻。 
//
// 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i]
//, nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。 
//
// 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：adjacentPairs = [[2,1],[3,4],[3,2]]
//输出：[1,2,3,4]
//解释：数组的所有相邻元素对都在 adjacentPairs 中。
//特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
// 
//
// 示例 2： 
//
// 
//输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
//输出：[-2,4,1,-3]
//解释：数组中可能存在负数。
//另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
// 
//
// 示例 3： 
//
// 
//输入：adjacentPairs = [[100000,-100000]]
//输出：[100000,-100000]
// 
//
// 
//
// 提示： 
//
// 
// nums.length == n 
// adjacentPairs.length == n - 1 
// adjacentPairs[i].length == 2 
// 2 <= n <= 105 
// -105 <= nums[i], ui, vi <= 105 
// 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums 
// 
// Related Topics 数组 哈希表 
// 👍 101 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 22:40:25
 */
public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        Solution solution = new RestoreTheArrayFromAdjacentPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for (int[] adjacentPair : adjacentPairs) {
                map.putIfAbsent(adjacentPair[0], new ArrayList<>());
                map.putIfAbsent(adjacentPair[1], new ArrayList<>());
                map.get(adjacentPair[0]).add(adjacentPair[1]);
                map.get(adjacentPair[1]).add(adjacentPair[0]);
            }

            int n = adjacentPairs.length + 1;
            int[] ret = new int[n];
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                int e = entry.getKey();
                List<Integer> adj = entry.getValue();
                if (adj.size() == 1) {
                    ret[0] = e;
                    break;
                }
            }

            ret[1] = map.get(ret[0]).get(0);
            for (int i = 2; i < n; i++) {
                List<Integer> adj = map.get(ret[i - 1]);
                ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}