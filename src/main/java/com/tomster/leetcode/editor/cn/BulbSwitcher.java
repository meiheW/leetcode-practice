//初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。 
//
// 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后
//一个灯泡的开关。 
//
// 找出并返回 n 轮后有多少个亮着的灯泡。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3
//输出：1 
//解释：
//初始时, 灯泡状态 [关闭, 关闭, 关闭].
//第一轮后, 灯泡状态 [开启, 开启, 开启].
//第二轮后, 灯泡状态 [开启, 关闭, 开启].
//第三轮后, 灯泡状态 [开启, 关闭, 关闭]. 
//
//你应该返回 1，因为只有一个灯泡还亮着。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 109 
// 
// Related Topics 脑筋急转弯 数学 
// 👍 293 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-05 13:27:36
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        Solution solution = new BulbSwitcher().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //初始状态是关闭的，所以只要是因数为奇数则最终状态是打开
        public int bulbSwitch(int n) {
            //1是肯定亮的
            return (int) Math.sqrt(n + 0.5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}