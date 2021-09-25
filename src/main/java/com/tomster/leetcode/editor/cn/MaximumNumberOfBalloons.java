//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 53 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 17:43:36
 */
public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfBalloons().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfBalloons(String text) {
            Map<Character, Integer> balloonMap = wordCount("balloon");
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : text.toCharArray()) {
                if (balloonMap.containsKey(c)) {
                    countMap.put(c, countMap.getOrDefault(c, 0) + 1);
                }
            }
            int ans = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : balloonMap.entrySet()) {
                int base = entry.getValue();
                int times = countMap.getOrDefault(entry.getKey(), 0);
                ans = Math.min(ans, times / base);
                if (ans == 0) {
                    break;
                }
            }
            return ans;
        }

        private Map<Character, Integer> wordCount(String licensePlate) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : licensePlate.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}