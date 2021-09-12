//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心 哈希表 双指针 字符串 
// 👍 565 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-12 21:46:04
 */
public class PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 输入：S = "ababcbacadefegdehijhklij"
         * 输出：[9,7,8]
         */
        public List<Integer> partitionLabels(String s) {
            List<Integer> result = new ArrayList<>();
            //保存字符最后一次出现的下标，可以用数组保存
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), i);
            }
            int cur = 0, far = 0, sum = 0;
            while (cur < s.length()) {
                sum++;
                far = Math.max(far, map.get(s.charAt(cur)));
                if (cur == far) {
                    result.add(sum);
                    sum = 0;
                    far = 0;
                }
                cur++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}