//给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构： 
//
// 
// 累加 ，将一个正整数加到 nums2 中指定下标对应元素上。 
// 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <=
// j < nums2.length）。 
// 
//
// 实现 FindSumPairs 类： 
//
// 
// FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 
//对象。 
// void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val
// 。 
// int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
//[[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 
//1], [7]]
//输出：
//[null, 8, null, 2, 1, null, null, 11]
//
//解释：
//FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 
//5, 4]);
//findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4)
// 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
//findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
//findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
//findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
//findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
//findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
//findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4)
//, (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 1000 
// 1 <= nums2.length <= 105 
// 1 <= nums1[i] <= 109 
// 1 <= nums2[i] <= 105 
// 0 <= index < nums2.length 
// 1 <= val <= 105 
// 1 <= tot <= 109 
// 最多调用 add 和 count 函数各 1000 次 
// 
// Related Topics 设计 数组 哈希表 
// 👍 9 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 23:03:10
 */
public class FindingPairsWithACertainSum {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FindSumPairs {
        //Map<Integer, Integer> countMap1;
        Map<Integer, Integer> countMap2;
        int[] nums2;
        int[] nums1;

        public FindSumPairs(int[] nums1, int[] nums2) {
            //this.countMap1 = countMap(nums1);
            this.countMap2 = countMap(nums2);
            this.nums2 = nums2;
            this.nums1 = nums1;
        }


        public void add(int index, int val) {
            int pre = nums2[index];
            countMap2.put(pre, countMap2.get(pre) - 1);
            /*if (countMap2.get(pre) == 0) {
                countMap2.remove(pre);
            }*/
            int cur = nums2[index] += val;
            countMap2.put(cur, countMap2.getOrDefault(cur, 0) + 1);
        }

        public int count(int tot) {
            int ans = 0;
            for (int nums : nums1) {
                int target = tot - nums;
                int count = countMap2.getOrDefault(target, 0);
                if (count != 0) {
                    ans += count;
                }
            }
            /*for (Map.Entry<Integer, Integer> entry : countMap1.entrySet()) {
                int target = tot - entry.getKey();
                int count = countMap2.getOrDefault(target, 0);
                if (count != 0) {
                    ans += entry.getValue() * count;
                }
            }*/
            return ans;
        }

        private Map<Integer, Integer> countMap(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return map;
        }
    }

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
//leetcode submit region end(Prohibit modification and deletion)

}