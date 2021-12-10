//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序
//或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 746 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-12-10 22:27:00
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            backTracing(ans, new ArrayList<>(), s);
            return ans;
        }

        private void backTracing(List<String> ans, List<String> temp, String s) {
            if (temp.size() >= 4 && s.length() != 0) {
                return;
            }
            if (temp.size() == 4) {
                ans.add(String.join(".", temp));
            }
            if (s.startsWith("0")) {
                temp.add("0");
                backTracing(ans, temp, s.substring(1));
                temp.remove(temp.size() - 1);
            } else {
                for (int i = 1; i <= Math.min(s.length(), 3); i++) {
                    if (Integer.parseInt(s.substring(0, i)) < 256) {
                        temp.add(s.substring(0, i));
                        backTracing(ans, temp, i == s.length() ? "" : s.substring(i));
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}