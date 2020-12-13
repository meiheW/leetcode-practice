//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1036 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: tomster
 * @data: 2020-12-13 14:39:03
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 广度优先搜索(BFS)
         * 这种搜索方式一般借助队列来实现数据的扩展
         *
         * @param digits
         * @return
         */
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return result;
            }
            Queue<String> queue = new LinkedBlockingDeque<>();
            queue.offer("");

            for (int i = 0; i < digits.length(); i++) {
                int num = digits.charAt(i) - '0';
                char[] chars = getChars(num);

                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String poll = queue.poll();
                    for (char c : chars) {
                        queue.offer(poll + c);
                    }
                }
            }

            return new ArrayList<>(queue);
        }

        /**
         * 数字和字母的映射
         *
         * @param i
         * @return
         */
        char[] getChars(int i) {
            switch (i) {
                case 2:
                    return new char[]{'a', 'b', 'c'};
                case 3:
                    return new char[]{'d', 'e', 'f'};
                case 4:
                    return new char[]{'g', 'h', 'i'};
                case 5:
                    return new char[]{'j', 'k', 'l'};
                case 6:
                    return new char[]{'m', 'n', 'o'};
                case 7:
                    return new char[]{'p', 'q', 'r', 's'};
                case 8:
                    return new char[]{'t', 'u', 'v'};
                case 9:
                    return new char[]{'w', 'x', 'y', 'z'};
                default:
                    return null;
            }
        }


        //
        //这虽然是一到简单题，但是给我们很多启示，看到这类题一定要想到考察的哪类基本算法

        /**
         * 我第一次AC的方法，非常一般，暴力解决，其实就是用了
         * 这虽然是一到简单题，但是给我们很多启示，看到这类题一定要想到考察的哪类基本算法
         * BFS,DFS,回溯,递归
         *
         * @param digits
         * @return
         */
        public List<String> letterCombinations1(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            for (int index = 0; index < digits.length(); index++) {
                int i = digits.charAt(index) - '0';
                char[] chars = getChars(i);
                if (res.size() == 0) {
                    for (char c : chars) {
                        res.add(c + "");
                    }
                } else {
                    List<String> newList = new ArrayList<>();
                    for (String ele : res) {
                        for (char c : chars) {
                            newList.add(ele + c);
                        }
                    }
                    res = newList;

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}