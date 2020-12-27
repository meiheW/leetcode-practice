//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1900 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2020-12-27 16:24:16
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这一题是看了en高赞靠前的答案
         * 双指针，记录左右最大的值即可
         * @param height
         * @return
         */
        public int trap(int[] height) {
            if (height == null || height.length <= 2) {
                return 0;
            }
            int left = 0;
            int right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int sum = 0;
            while (left <= right) {
                if (height[left] <= height[right]) {
                    if (height[left] >= leftMax) {
                        leftMax = height[left];
                    } else {
                        sum += (leftMax - height[left]);
                    }
                    left++;
                } else {
                    if (height[right] >= rightMax) {
                        rightMax = height[right];
                    } else {
                        sum += (rightMax - height[right]);
                    }
                    right--;
                }
            }
            return sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}