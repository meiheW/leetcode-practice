//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 323 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-28 11:54:03
 */
public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int left = j + 1, right = nums.length - 1;
                    int target = nums[i] + nums[j];
                    //二分 - 自己写出来的，嘎嘎
                    while (left <= right) {
                        int middle = left + (right - left) / 2;
                        if (nums[middle] < target) {
                            left = middle + 1;
                        } else {
                            right = middle - 1;
                        }
                    }
                    ans += (right - j);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}