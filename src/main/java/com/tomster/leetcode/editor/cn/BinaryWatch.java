//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "3:25" 。 
// 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯 
// 👍 354 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-03-29 14:57:01
 */
public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        List<String> strings = solution.readBinaryWatch(1);
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> ans = new ArrayList<>();
            int[] temp = new int[10];
            backTracing(ans, temp, 0, 0, turnedOn);
            return ans;
        }

        private void backTracing(List<String> ans, int[] temp, int start, int count, int turnedOn) {
            if (count == turnedOn) {
                int[] time = getTime(temp);
                int h = time[0], m = time[1];
                if (h < 12 && m < 60) {
                    ans.add(h + ":" + (m < 10 ? "0" + m : m));
                }
                return;
            }
            for (int i = start; i < temp.length; i++) {
                temp[i] = 1;
                backTracing(ans, temp, i + 1, count + 1, turnedOn);
                temp[i] = 0;
            }
        }

        private int[] getTime(int[] arr) {
            int h = 0;
            for (int i = 0; i < 4; i++) {
                if (arr[i] == 1) {
                    h += Math.pow(2, i);
                }
            }

            int m = 0;
            for (int i = 4; i < 10; i++) {
                if (arr[i] == 1) {
                    m += Math.pow(2, i - 4);
                }
            }
            return new int[]{h, m};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}