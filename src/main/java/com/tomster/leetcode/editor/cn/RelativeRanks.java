//给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
// "Silver Medal", "Bronze Medal"）。 
//
// (注：分数越高的选手，排名越靠前。) 
//
// 示例 1: 
//
// 
//输入: [5, 4, 3, 2, 1]
//输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and 
//"Bronze Medal").
//余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。 
//
// 提示: 
//
// 
// N 是一个正整数并且不会超过 10000。 
// 所有运动员的成绩都不相同。 
// 
// Related Topics 数组 排序 堆（优先队列） 
// 👍 79 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author: tomster
 * @data: 2021-07-26 17:17:41
 */
public class RelativeRanks {
    public static void main(String[] args) {
        Solution solution = new RelativeRanks().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};
            //最大堆，存储score数组的索引
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> score[o2] - score[o1]);
            for (int i = 0; i < score.length; i++) {
                pq.add(i);
            }
            String[] result = new String[score.length];
            int index = 0;
            while (!pq.isEmpty()) {
                result[pq.poll()] = index < 3 ? medal[index] : String.valueOf(index + 1);
                ++index;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}