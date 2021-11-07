//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。 
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 
//任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
// 
//
// 示例 2： 
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 示例 3： 
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= changed.length <= 105 
// 0 <= changed[i] <= 105 
// 
// Related Topics 贪心 数组 哈希表 排序 
// 👍 9 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-07 10:09:36
 */
public class FindOriginalArrayFromDoubledArray {
    public static void main(String[] args) {
        Solution solution = new FindOriginalArrayFromDoubledArray().new Solution();
        int[] originalArray = solution.findOriginalArray(new int[]{2, 5, 4, 2, 4});
        System.out.println(Arrays.toString(originalArray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        final int N = (int) Math.pow(10, 5);

        public int[] findOriginalArray(int[] changed) {
            int[] count = new int[N + 1];
            for (int i : changed) {
                count[i]++;
            }
            if (changed.length % 2 == 1) {
                return new int[]{};
            }
            int n = changed.length / 2;
            int[] ans = new int[n];
            int index = 0;
            //0的情况
            if (count[0] != 0) {
                if (count[0] % 2 == 0) {
                    for (int i = 0; i < count[0] / 2; i++) {
                        ans[index++] = 0;
                    }
                } else {
                    return new int[]{};
                }
            }
            //计数统计
            for (int i = 1; i <= N / 2; i++) {
                if (count[i] != 0) {
                    if (count[2 * i] < count[i]) {
                        return new int[]{};
                    } else {
                        count[2 * i] -= count[i];
                        int k = count[i];
                        while (k-- > 0) {
                            ans[index++] = i;
                        }
                        if (index == n) {
                            return ans;
                        }
                    }
                }
            }
            return index == n ? ans : new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}