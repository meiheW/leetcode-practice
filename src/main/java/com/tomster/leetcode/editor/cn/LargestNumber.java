//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 707 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tomster
 * @data: 2021-05-15 13:01:45
 */
public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            List<String> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(String.valueOf(num));
            }
            numList = numList.stream().sorted((o1, o2) -> {
                //30和3：330 > 303
                return o1.equals(o2) ? 0 : (o1 + o2).compareTo(o2 + o1);
            }).collect(Collectors.toList());
            if ("0".equals(numList.get(numList.size() - 1))) {
                return "0";
            }
            StringBuilder result = new StringBuilder();
            for (int i = numList.size() - 1; i >= 0; i--) {
                result.append(numList.get(i));
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}