//在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。 
//
// 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足 i < j 且有 (time[i] + tim
//e[j]) % 60 == 0。 
//
// 
//
// 示例 1： 
//
// 输入：[30,20,150,100,40]
//输出：3
//解释：这三对的总持续时间可被 60 整数：
//(time[0] = 30, time[2] = 150): 总持续时间 180
//(time[1] = 20, time[3] = 100): 总持续时间 120
//(time[1] = 20, time[4] = 40): 总持续时间 60
// 
//
// 示例 2： 
//
// 输入：[60,60,60]
//输出：3
//解释：所有三对的总持续时间都是 120，可以被 60 整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= time.length <= 60000 
// 1 <= time[i] <= 500 
// 
// Related Topics 数组 哈希表 计数 
// 👍 160 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-10-31 21:08:33
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        Solution solution = new PairsOfSongsWithTotalDurationsDivisibleBy60().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0, base = 60;
            for (int i : time) {
                int remainder = i % base;
                ans += map.getOrDefault(remainder == 0 ? 0 : base - remainder, 0);
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}