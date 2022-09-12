/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 0 < nums.length <= 100
 * <p>
 * <p>
 * 说明:
 * <p>
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * <p>
 * Related Topics 贪心 字符串 排序 👍 541 👎 0
 */
package com.tomster.leetcode.editor.cn;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-09-12 14:14:12
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            List<String> arr = new ArrayList<>();
            for (int num : nums) {
                arr.add(num + "");
            }
            arr.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}