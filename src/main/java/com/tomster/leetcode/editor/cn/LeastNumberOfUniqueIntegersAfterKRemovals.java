//给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,5,4], k = 1
//输出：1
//解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
// 
//
// 示例 2： 
//
// 输入：arr = [4,3,1,1,3,3,2], k = 3
//输出：2
//解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 10^9 
// 0 <= k <= arr.length 
// 
// Related Topics 排序 数组 
// 👍 26 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-05-15 22:58:37
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        Solution solution = new LeastNumberOfUniqueIntegersAfterKRemovals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            }
            TreeMap<Integer, Integer> freqMap = new TreeMap<>();
            for (Integer count : countMap.values()) {
                freqMap.put(count, freqMap.getOrDefault(count, 0) + 1);
            }
            int totalNum = countMap.size();
            int numCount = 0;
            while (k > 0 && !freqMap.isEmpty()) {
                Map.Entry<Integer, Integer> entry = freqMap.pollFirstEntry();
                int count = entry.getKey();
                int freq = entry.getValue();
                if (k > freq * count) {
                    k -= freq * count;
                    numCount += freq;
                } else if (k <= freq * count) {
                    numCount += k / count;
                    k = 0;
                }
            }
            return totalNum-numCount;
        }

        public int findLeastNumOfUniqueInts1(int[] arr, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int value : arr) {
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                list.add(value);
            }
            list.sort((o1, o2) -> !countMap.get(o1).equals(countMap.get(o2))
                    ? Integer.compare(countMap.get(o1), countMap.get(o2))
                    : Integer.compare(o1, o2));
            Set<Integer> set = new HashSet<>();
            for (int i = k; i < list.size(); i++) {
                set.add(list.get(i));
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}