//给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。 
//
// 返回值小于或等于 bound 的所有强整数组成的列表。 
//
// 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。 
//
// 
//
// 示例 1： 
//
// 输入：x = 2, y = 3, bound = 10
//输出：[2,3,4,5,7,9,10]
//解释： 
//2 = 2^0 + 3^0
//3 = 2^1 + 3^0
//4 = 2^0 + 3^1
//5 = 2^1 + 3^1
//7 = 2^2 + 3^1
//9 = 2^3 + 3^0
//10 = 2^0 + 3^2
// 
//
// 示例 2： 
//
// 输入：x = 3, y = 5, bound = 15
//输出：[2,4,6,8,10,14]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 100 
// 1 <= y <= 100 
// 0 <= bound <= 10^6 
// 
// Related Topics 哈希表 数学 
// 👍 53 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: tomster
 * @data: 2021-09-14 20:08:56
 */
public class PowerfulIntegers {
    public static void main(String[] args) {
        Solution solution = new PowerfulIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < 20 && Math.pow(x, i) <= bound; ++i) {
                for (int j = 0; j < 20 && Math.pow(y, j) <= bound; ++j) {
                    int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                    if (v <= bound) {
                        seen.add(v);
                    }
                }
            }
            return new ArrayList<>(seen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}