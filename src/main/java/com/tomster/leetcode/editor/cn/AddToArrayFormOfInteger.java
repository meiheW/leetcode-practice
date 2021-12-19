//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 数学 
// 👍 177 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-12-19 16:47:33
 */
public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //这种非整数加法，用这个循环很好解决
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> ans = new ArrayList<>();
            int index = num.length - 1;
            int carry = 0;
            while (index >= 0 || k > 0 || carry > 0) {
                int cur = carry;
                if (k > 0) {
                    cur += k % 10;
                    k /= 10;
                }
                if (index >= 0) {
                    cur += num[index];
                    index--;
                }
                carry = cur / 10;
                ans.add(cur % 10);
            }
            Collections.reverse(ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}