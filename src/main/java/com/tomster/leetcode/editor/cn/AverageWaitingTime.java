//有一个餐厅，只有一位厨师。你有一个顾客数组 customers ，其中 customers[i] = [arrivali, timei] ： 
//
// 
// arrivali 是第 i 位顾客到达的时间，到达时间按 非递减 顺序排列。 
// timei 是给第 i 位顾客做菜需要的时间。 
// 
//
// 当一位顾客到达时，他将他的订单给厨师，厨师一旦空闲的时候就开始做这位顾客的菜。每位顾客会一直等待到厨师完成他的订单。厨师同时只能做一个人的订单。厨师会严格
//按照 订单给他的顺序 做菜。 
//
// 请你返回所有顾客需要等待的 平均 时间。与标准答案误差在 10-5 范围以内，都视为正确结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：customers = [[1,2],[2,5],[4,3]]
//输出：5.00000
//解释：
//1) 第一位顾客在时刻 1 到达，厨师拿到他的订单并在时刻 1 立马开始做菜，并在时刻 3 完成，第一位顾客等待时间为 3 - 1 = 2 。
//2) 第二位顾客在时刻 2 到达，厨师在时刻 3 开始为他做菜，并在时刻 8 完成，第二位顾客等待时间为 8 - 2 = 6 。
//3) 第三位顾客在时刻 4 到达，厨师在时刻 8 开始为他做菜，并在时刻 11 完成，第三位顾客等待时间为 11 - 4 = 7 。
//平均等待时间为 (2 + 6 + 7) / 3 = 5 。
// 
//
// 示例 2： 
//
// 
//输入：customers = [[5,2],[5,4],[10,3],[20,1]]
//输出：3.25000
//解释：
//1) 第一位顾客在时刻 5 到达，厨师拿到他的订单并在时刻 5 立马开始做菜，并在时刻 7 完成，第一位顾客等待时间为 7 - 5 = 2 。
//2) 第二位顾客在时刻 5 到达，厨师在时刻 7 开始为他做菜，并在时刻 11 完成，第二位顾客等待时间为 11 - 5 = 6 。
//3) 第三位顾客在时刻 10 到达，厨师在时刻 11 开始为他做菜，并在时刻 14 完成，第三位顾客等待时间为 14 - 10 = 4 。
//4) 第四位顾客在时刻 20 到达，厨师拿到他的订单并在时刻 20 立马开始做菜，并在时刻 21 完成，第四位顾客等待时间为 21 - 20 = 1 。
//平均等待时间为 (2 + 6 + 4 + 1) / 4 = 3.25 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= customers.length <= 105 
// 1 <= arrivali, timei <= 104 
// arrivali <= arrivali+1 
// 
// Related Topics 数组 模拟 
// 👍 4 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-10-30 11:45:46
 */
public class AverageWaitingTime {
    public static void main(String[] args) {
        Solution solution = new AverageWaitingTime().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double averageWaitingTime(int[][] customers) {
            int lastFinish = 0;
            long costSum = 0;
            for (int[] customer : customers) {
                //当前顾客花费的时间 = 吃饭时间 + 早来等待的时间
                long cost = customer[1] + Math.max(0, lastFinish - customer[0]);
                costSum += cost;
                //当前顾客离开的时间 = 开始吃的时间 + 吃饭时间
                lastFinish = Math.max(customer[0], lastFinish) + customer[1];
            }
            return 1.0 * costSum / customers.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}