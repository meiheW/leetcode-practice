//公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCos
//ti ，飞往 b 市的费用为 bCosti 。 
//
// 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。 
//
// 
//
// 示例 1： 
//
// 
//输入：costs = [[10,20],[30,200],[400,50],[30,20]]
//输出：110
//解释：
//第一个人去 a 市，费用为 10。
//第二个人去 a 市，费用为 30。
//第三个人去 b 市，费用为 50。
//第四个人去 b 市，费用为 20。
//
//最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
// 
//
// 示例 2： 
//
// 
//输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
//输出：1859
// 
//
// 示例 3： 
//
// 
//输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,35
//9],[631,42]]
//输出：3086
// 
//
// 
//
// 提示： 
//
// 
// 2 * n == costs.length 
// 2 <= costs.length <= 100 
// costs.length 为偶数 
// 1 <= aCosti, bCosti <= 1000 
// 
// Related Topics 贪心 数组 排序 
// 👍 219 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: tomster
 * @data: 2021-11-29 22:41:22
 */
public class TwoCityScheduling {
    public static void main(String[] args) {
        Solution solution = new TwoCityScheduling().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            //所有人都去B地
            int sum = 0;
            for (int[] cost : costs) {
                sum += cost[1];
            }
            //根据priceA-priceB排序
            Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));
            for (int i = 0; i < costs.length / 2; i++) {
                sum += (costs[i][0] - costs[i][1]);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}