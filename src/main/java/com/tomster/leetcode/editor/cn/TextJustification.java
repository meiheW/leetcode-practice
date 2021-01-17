//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 
// 👍 121 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tomster
 * @data: 2021-01-17 17:04:32
 */
public class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = solution.fullJustify(words, 16);
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 先分组，在对齐
         *
         * @param words
         * @param maxWidth
         * @return
         */
        public List<String> fullJustify(String[] words, int maxWidth) {
            int curMaxWidth = 0;
            int p = 0;
            List<List<Integer>> indexList = new ArrayList<>();
            List<Integer> curList = new ArrayList<>();
            while (p != words.length) {
                if (p == 0) {
                    curList.add(p);
                    curMaxWidth += words[p].length();
                } else {
                    //p不为0
                    int addMaxWith = curMaxWidth + 1 + words[p].length();
                    if (addMaxWith > maxWidth) {
                        indexList.add(curList);
                        curList = new ArrayList<>();
                        curList.add(p);
                        curMaxWidth = words[p].length();
                    } else {
                        curList.add(p);
                        curMaxWidth = addMaxWith;
                    }
                }
                p++;
            }
            if (!curList.isEmpty()) {
                indexList.add(curList);
            }

            //indexList -> List<String>
            List<String> result = new ArrayList<>();
            for (int i = 0; i < indexList.size(); i++) {
                List<Integer> indexes = indexList.get(i);
                //只有一个元素
                if (indexes.size() == 1) {
                    String word = words[indexes.get(0)];
                    StringBuilder line = new StringBuilder(word);
                    String spaceStr = String.join("", Collections.nCopies(maxWidth - word.length(), " "));
                    line.append(spaceStr);
                    result.add(line.toString());
                } else if (i == indexList.size() - 1) {
                    //最后一个元素
                    String join = indexes.stream().map(e -> words[e]).collect(Collectors.joining(" "));
                    String spaceStr = String.join("", Collections.nCopies(maxWidth - join.length(), " "));
                    StringBuilder line = new StringBuilder(join);
                    line.append(spaceStr);
                    result.add(line.toString());
                } else {
                    //其余情况
                    int wLength = 0;
                    for (int index : indexes) {
                        wLength += words[index].length();
                    }
                    int rest = maxWidth - wLength;
                    int gap = rest / (indexes.size() - 1);
                    int ogap = rest % (indexes.size() - 1);

                    StringBuilder line = new StringBuilder(words[indexes.get(0)]);
                    for (int index = 1; index < indexes.size(); index++) {
                        int spaceNum = index <= ogap ? gap + 1 : gap;
                        String spaceStr = String.join("", Collections.nCopies(spaceNum, " "));
                        line.append(spaceStr).append(words[indexes.get(index)]);
                    }
                    result.add(line.toString());
                }


            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}