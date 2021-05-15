//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 输入：[1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// 
// Related Topics 堆 排序 
// 👍 63 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-05-15 13:50:02
 */
public class DistantBarcodes {
    public static void main(String[] args) {
        Solution solution = new DistantBarcodes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < barcodes.length; i++) {
                countMap.put(barcodes[i], countMap.getOrDefault(barcodes[i], 0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> countMap.get(o2) - countMap.get(o1));
            pq.addAll(countMap.keySet());

            List<Integer> resultList = new ArrayList<>();

            while (pq.size() > 1) {
                int peek1 = pq.poll();
                int peek2 = pq.poll();
                resultList.add(peek1);
                resultList.add(peek2);
                //更新map和pq
                countMap.put(peek1, countMap.get(peek1) - 1);
                countMap.put(peek2, countMap.get(peek2) - 1);
                if (countMap.get(peek1) != 0) {
                    pq.add(peek1);
                }
                if (countMap.get(peek2) != 0) {
                    pq.add(peek2);
                }
            }
            if (!pq.isEmpty()) {
                resultList.add(pq.poll());
            }
            return resultList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}