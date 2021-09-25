//有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每
//位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。 
//
// 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。 
//
// 
//
// 示例 1： 
//
// 输入：groupSizes = [3,3,3,3,3,1,3]
//输出：[[5],[0,1,2],[3,4,6]]
//解释： 
//其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
// 
//
// 示例 2： 
//
// 输入：groupSizes = [2,1,3,3,3,2]
//输出：[[1],[0,5],[2,3,4]]
// 
//
// 
//
// 提示： 
//
// 
// groupSizes.length == n 
// 1 <= n <= 500 
// 1 <= groupSizes[i] <= n 
// 
// Related Topics 数组 哈希表 
// 👍 52 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 19:02:46
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        Solution solution = new GroupThePeopleGivenTheGroupSizeTheyBelongTo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            /*build a map key:size; value:the indexes of the size*/
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++) {
                int size = groupSizes[i];
                map.computeIfAbsent(size, e -> new ArrayList<>());
                map.get(size).add(i);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                int size = entry.getKey();
                for (int i = 0; i < list.size() / size; i++) {
                    ans.add(list.subList(i * size, (i + 1) * size));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}