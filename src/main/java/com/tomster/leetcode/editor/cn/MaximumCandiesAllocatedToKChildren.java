/**
 * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，
 * 但 无法 再将两堆合并到一起。
 * <p>
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
 * <p>
 * 返回每个小孩可以拿走的 最大糖果数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：candies = [5,8,6], k = 3
 * 输出：5
 * 解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。现在就有五堆大小分别为
 * 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：candies = [2,5], k = 11
 * 输出：0
 * 解释：总共有 11 个小孩，但只有 7 颗糖果，但如果要分配糖果的话，必须保证每个小孩至少能得到 1 颗糖果。因此，最后每个小孩都没有得到糖果，答案是 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= candies.length <= 10⁵
 * 1 <= candies[i] <= 10⁷
 * 1 <= k <= 10¹²
 * <p>
 * Related Topics 数组 二分查找 👍 31 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-08-31 17:42:42
 */
public class MaximumCandiesAllocatedToKChildren {
    public static void main(String[] args) {
        Solution solution = new MaximumCandiesAllocatedToKChildren().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            int max = 0;
            for (int candy : candies) {
                max = Math.max(max, candy);
            }
            int low = 1, high = max;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                long count = getCount(candies, mid);
                if (count >= k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low - 1;
        }

        private long getCount(int[] candies, int mid) {
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}