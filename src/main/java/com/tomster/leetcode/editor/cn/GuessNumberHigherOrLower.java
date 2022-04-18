//猜数字游戏的规则如下： 
//
// 
// 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。 
// 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。 
// 
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）： 
//
// 
// -1：我选出的数字比你猜的数字小 pick < num 
// 1：我选出的数字比你猜的数字大 pick > num 
// 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num 
// 
//
// 返回我选出的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10, pick = 6
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 1, pick = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 2, pick = 1
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：n = 2, pick = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 1 <= pick <= n 
// 
// Related Topics 二分查找 交互 
// 👍 201 👎 0

package com.tomster.leetcode.editor.cn;

import com.tomster.leetcode.api.GuessGame;

/**
 * @author: tomster
 * @data: 2022-04-18 17:54:18
 */
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        Solution solution = new GuessNumberHigherOrLower().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (low <= high) {
                int middle = low + (high - low) / 2;
                int res = guess(middle);
                if (res == -1) {
                    high = middle - 1;
                } else if (res == 1) {
                    low = middle + 1;
                } else {
                    return middle;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}