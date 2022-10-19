/**
 * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] <
 * answer[1] < numbers.length 。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= numbers.length <= 3 * 10⁴
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 167 题相似（下标起点不同）：https://leetcode-cn.com/problems/two-sum-ii-input-
 * array-is-sorted/
 * Related Topics 数组 双指针 二分查找 👍 50 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-10-19 10:27:13
 */
public class KLl5u1 {
    public static void main(String[] args) {
        Solution solution = new KLl5u1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                if (numbers[low] + numbers[high] < target) {
                    low++;
                } else if (numbers[low] + numbers[high] > target) {
                    high--;
                } else {
                    return new int[]{low, high};
                }
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}