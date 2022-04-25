//请你设计一个迭代器类 CombinationIterator ，包括以下内容： 
//
// 
// CombinationIterator(string characters, int combinationLength) 一个构造函数，输入参数包括：用
//一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。 
// 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。 
// 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 true 
// 
//
// 
//
// 示例 1： 
//
// 
//输入:
//["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext
//"]
//[["abc", 2], [], [], [], [], [], []]
//输出：
//[null, "ab", true, "ac", true, "bc", false]
//解释：
//CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 ite
//rator
//iterator.next(); // 返回 "ab"
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 "ac"
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 "bc"
//iterator.hasNext(); // 返回 false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= combinationLength <= characters.length <= 15 
// characters 中每个字符都 不同 
// 每组测试数据最多对 next 和 hasNext 调用 104次 
// 题目保证每次调用函数 next 时都存在下一个字母组合。 
// 
// Related Topics 设计 字符串 回溯 迭代器 
// 👍 55 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: tomster
 * @data: 2022-04-25 15:47:39
 */
public class IteratorForCombination {
    public static void main(String[] args) {
        //Solution solution = new IteratorForCombination().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CombinationIterator {

        List<String> ans;

        Iterator<String> it;

        public CombinationIterator(String characters, int combinationLength) {
            ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            backTracing(ans, sb, characters, combinationLength, 0);
            it = ans.iterator();
        }

        //回溯
        private void backTracing(List<String> ans, StringBuilder sb, String str, int k, int index) {
            if (sb.length() == k) {
                ans.add(sb.toString());
                return;
            }
            for (int i = index; i < str.length(); i++) {
                sb.append(str.charAt(i));
                backTracing(ans, sb, str, k, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public String next() {
            return it.next();
        }

        public boolean hasNext() {
            return it.hasNext();
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}