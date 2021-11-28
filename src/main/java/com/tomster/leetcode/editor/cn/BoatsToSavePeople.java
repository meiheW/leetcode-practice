//第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。 
//
// 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。 
//
// 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。 
//
// 
//
// 示例 1： 
//
// 输入：people = [1,2], limit = 3
//输出：1
//解释：1 艘船载 (1, 2)
// 
//
// 示例 2： 
//
// 输入：people = [3,2,2,1], limit = 3
//输出：3
//解释：3 艘船分别载 (1, 2), (2) 和 (3)
// 
//
// 示例 3： 
//
// 输入：people = [3,5,3,4], limit = 5
//输出：4
//解释：4 艘船分别载 (3), (3), (4), (5) 
//
// 提示： 
//
// 
// 1 <= people.length <= 50000 
// 1 <= people[i] <= limit <= 30000 
// 
// Related Topics 贪心 数组 双指针 排序 
// 👍 192 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-11-28 15:30:43
 */
public class BoatsToSavePeople {
    public static void main(String[] args) {
        Solution solution = new BoatsToSavePeople().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 计数排序+双指针优化
         * https://leetcode-cn.com/problems/boats-to-save-people
         * /solution/ji-shu-pai-xu-shuang-zhi-zhen-ji-bai-100-lt3o/
         */
        public int numRescueBoats1(int[] people, int limit) {
            int[] arr = new int[limit + 1];
            for (int person : people) {
                arr[person]++;
            }
            int low = 0, high = limit;
            int ans = 0;
            while (low < high) {
                while (low < high && arr[low] == 0) {
                    low++;
                }
                while (low < high && arr[high] == 0) {
                    high--;
                }
                if (low == high) {
                    break;
                }
                if (low + high > limit) {
                    ans += arr[high];
                    arr[high] = 0;
                } else {
                    int min = Math.min(arr[low], arr[high]);
                    ans += min;
                    arr[low] -= min;
                    arr[high] -= min;
                }
            }
            if (low == high) {
                ans += 2 * low > limit ? arr[low] : (arr[low] + 1) / 2;
            }
            return ans;
        }


        /**
         * 我的方法：排序+双指针
         */
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int ans = 0;
            int low = 0, high = people.length - 1;
            while (low <= high) {
                if (people[low] + people[high] <= limit) {
                    low++;
                }
                high--;
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}