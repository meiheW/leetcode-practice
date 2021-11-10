//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 ke
//y 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 108 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-10 11:13:10
 */
public class MapSumPairs {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {
        TrieNode root;

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int val;
        }


        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode node = root;
            char[] arr = key.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.val = val;
        }

        public int sum(String prefix) {
            TrieNode node = root;
            char[] arr = prefix.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (node.children[index] == null) {
                    return 0;
                }
                node = node.children[index];
            }
            return dfs(node);
        }

        private int dfs(TrieNode node) {
            if (node == null) {
                return 0;
            }
            int ans = node.val;
            for (int i = 0; i < 26; i++) {
                TrieNode cur = node.children[i];
                ans += dfs(cur);
            }
            return ans;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}