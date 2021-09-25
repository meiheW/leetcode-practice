//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。 
//
// 实现 MyHashMap 类： 
//
// 
// MyHashMap() 用空映射初始化对象 
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
//则更新其对应的值 value 。 
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= key, value <= 106 
// 最多调用 104 次 put、get 和 remove 方法 
// 
//
// 
//
// 进阶：你能否不使用内置的 HashMap 库解决此问题？ 
// Related Topics 设计 数组 哈希表 链表 哈希函数 
// 👍 232 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-09-25 15:53:05
 */
public class DesignHashmap {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {
        class Node {
            int hash;
            int key;
            int value;
            Node next;

            Node(int hash, int key, int value, Node next) {
                this.hash = hash;
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        int capacity = 16;

        Node[] table;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            table = new Node[capacity];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int hash = hash(key);
            Node head;
            if ((head = table[hash]) == null) {
                table[hash] = new Node(hash, key, value, null);
            } else {
                Node cur = head;
                while (cur.key != key && cur.next != null) {
                    cur = cur.next;
                }
                if (cur.key == key) {
                    cur.value = value;
                } else {
                    cur.next = new Node(hash, key, value, null);
                }
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int hash = hash(key);
            Node head;
            if ((head = table[hash]) == null) {
                return -1;
            } else {
                Node p = head;
                while (p != null) {
                    if (p.key == key) {
                        return p.value;
                    }
                    p = p.next;
                }
                return -1;
            }
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int hash = hash(key);
            Node head;
            if ((head = table[hash]) == null) {
                return;
            }
            //delete node of a linked list
            if (head.key == key) {
                table[hash] = head.next;
            } else {
                Node pre = head;
                while (pre.next != null && pre.next.key != key) {
                    pre = pre.next;
                }
                if (pre.next != null) {
                    pre.next = pre.next.next;
                }
            }
        }

        private int hash(int key) {
            return (capacity - 1) & key;
        }

    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}