//设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。 
//
// 注意: 允许出现重复元素。 
//
// 
// insert(val)：向集合中插入元素 val。 
// remove(val)：当 val 存在时，从集合中移除一个 val。 
// getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。 
// 
//
// 示例: 
//
// // 初始化一个空的集合。
//RandomizedCollection collection = new RandomizedCollection();
//
//// 向集合中插入 1 。返回 true 表示集合不包含 1 。
//collection.insert(1);
//
//// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//collection.insert(1);
//
//// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//collection.insert(2);
//
//// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//collection.getRandom();
//
//// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//collection.remove(1);
//
//// getRandom 应有相同概率返回 1 和 2 。
//collection.getRandom();
// 
// Related Topics 设计 数组 哈希表 数学 随机化 
// 👍 226 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-11-10 10:58:39
 */
public class InsertDeleteGetrandomO1DuplicatesAllowed {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedCollection {

        List<Integer> list;
        Map<Integer, List<Integer>> map;
        Random random = new Random();

        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            boolean contained = false;
            if (map.containsKey(val)) {
                contained = true;
            }
            List<Integer> idxList = map.computeIfAbsent(val, e -> new ArrayList<>());
            idxList.add(list.size());
            list.add(val);
            return !contained;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int n = list.size();
            //val的第一个下标
            List<Integer> idxList = map.get(val);
            Integer idx = idxList.get(0);
            //最后一个元素操作
            int lastElement = list.get(n - 1);
            list.set(idx, lastElement);
            List<Integer> lastIndexList = map.get(lastElement);
            lastIndexList.add(idx);
            lastIndexList.remove(Integer.valueOf(n - 1));
            //对list操作
            list.remove(n - 1);
            idxList.remove(idx);
            if (idxList.isEmpty()) {
                map.remove(val);
            }
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }

    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}