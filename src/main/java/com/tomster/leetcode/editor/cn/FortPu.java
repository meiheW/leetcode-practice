/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：
 * <p>
 * <p>
 * insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
 * getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 :
 * <p>
 * <p>
 * 输入: inputs = ["RandomizedSet", "insert", "remove", "insert", "getRandom",
 * "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出: [null, true, false, true, 2, true, false, 2]
 * 解释:
 * RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
 * randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入
 * <p>
 * randomSet.remove(2); // 返回 false，表示集合中不存在 2
 * <p>
 * randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2]
 * <p>
 * randomSet.getRandom(); // getRandom 应随机返回 1 或 2
 * <p>
 * randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2]
 * <p>
 * randomSet.insert(2); // 2 已在集合中，所以返回 false
 * <p>
 * randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -2³¹ <= val <= 2³¹ - 1
 * 最多进行 2 * 10⁵ 次 insert ， remove 和 getRandom 方法调用
 * 当调用 getRandom 方法时，集合中至少有一个元素
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 380 题相同：https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * Related Topics 设计 数组 哈希表 数学 随机化 👍 50 👎 0
 */
package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2022-11-05 21:28:54
 */
public class FortPu {
    public static void main(String[] args) {
        //Solution solution = new FortPu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {

        //记录数据与所在列表下标
        Map<Integer, Integer> map;
        //存储数据
        List<Integer> list;
        //生成随机数
        Random r;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            r = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            //获取val下标，并将最后一个元素复制过来
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(index, last);
            list.remove(list.size() - 1);
            map.put(last, index);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(r.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}