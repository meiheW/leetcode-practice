//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 
// 👍 387 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-30 09:37:52
 */
public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        //Solution solution = new DesignAddAndSearchWordsDataStructure().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        class Trie {
            Trie[] children;
            boolean isEnd;

            Trie() {
                children = new Trie[26];
                isEnd = false;
            }

            public void insert(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new Trie();
                    }
                    node = node.children[index];
                }
                node.isEnd = true;
            }
        }

        Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            root.insert(word);
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int index, Trie node) {
            if (index == word.length()) {
                return node.isEnd;
            }
            char c = word.charAt(index);
            if (Character.isLetter(c)) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
                return dfs(word, index + 1, node);
            } else {
                for (int i = 0; i < 26; i++) {
                    Trie children = node.children[i];
                    if (children != null && dfs(word, index + 1, children)) {
                        return true;
                    }
                }
                return false;
            }

        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}