//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 字典树 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 362 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-07-26 17:24:57
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {

            Map<String, Integer> count = new HashMap<>();
            for (String word : words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
            /*1.数组排序
            List<String> candidates = new ArrayList<>(count.keySet());
            candidates.sort((o1, o2) -> {
                if (count.get(o1).equals(count.get(o2))) {
                    return o1.compareTo(o2);
                } else {
                    return count.get(o2) - count.get(o1);
                }
            });
            return candidates.subList(0, k);*/

            //排序方式与上述相反
            PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
                if (count.get(o1).equals(count.get(o2))) {
                    return o2.compareTo(o1);
                } else {
                    return count.get(o1) - count.get(o2);
                }
            });
            for (String s : count.keySet()) {
                pq.add(s);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            List<String> result = new ArrayList<>();
            while (!pq.isEmpty()) {
                result.add(pq.poll());
            }
            Collections.reverse(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}