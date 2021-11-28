//数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连
//接的结果和按升序排序后的原数组相同。 
//
// 我们最多能将数组分成多少块？ 
//
// 示例 1: 
//
// 输入: arr = [4,3,2,1,0]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
// 
//
// 示例 2: 
//
// 输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
// 
//
// 注意: 
//
// 
// arr 的长度在 [1, 10] 之间。 
// arr[i]是 [0, 1, ..., arr.length - 1]的一种排列。 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 
// 👍 163 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-28 12:21:51
 */
public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new MaxChunksToMakeSorted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int ans = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
                if (max == i) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}