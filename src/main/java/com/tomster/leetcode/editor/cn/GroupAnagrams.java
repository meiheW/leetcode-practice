//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 620 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-01-02 20:19:24
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null) {
                return null;
            }
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                String hash = hash(s);
                if(!map.containsKey(hash)){
                    map.put(hash, new ArrayList<>());
                }
                map.get(hash).add(s);
            }

            return new ArrayList<>(map.values());
        }

        private String hash(String s) {
            int[] ac = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                ac[c - 'a']++;
            }

            //return String.valueOf(ac); 这个是数组的地址
            return Arrays.toString(ac);

        }


        /**
         * 第一个思路是直接求每个字符串的全排列，与后面的对比，并放到一个列表里面
         * 通过验证是正确的，但是当输入较多时，程序运行会超时
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams_1(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            if (strs == null || strs.length == 0) {
                return result;
            }

            boolean[] checked = new boolean[strs.length];
            for (int i = 0; i < strs.length; i++) {
                if (checked[i]) {
                    continue;
                }

                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                List<String> permutations = permutations(strs[i].toCharArray());
                for (int j = i + 1; j < strs.length; j++) {
                    if (permutations.contains(strs[j])) {
                        list.add(strs[j]);
                        checked[j] = true;
                    }
                }
                result.add(list);
                checked[i] = true;
            }
            return result;

        }


        private List<String> permutations(char[] chars) {
            List<String> permutations = new ArrayList<>();
            boolean[] used = new boolean[chars.length];
            Arrays.sort(chars);
            backTrace(permutations, chars, new ArrayList<Character>(), used);
            return permutations;
        }

        private void backTrace(List<String> permutations, char[] chars, ArrayList<Character> temp, boolean[] used) {
            if (chars.length == temp.size()) {
                StringBuilder sb = new StringBuilder();
                for (Character character : temp) {
                    sb.append(character);
                }
                permutations.add(sb.toString());
            }
            for (int i = 0; i < chars.length; i++) {
                if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                temp.add(chars[i]);
                backTrace(permutations, chars, temp, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}