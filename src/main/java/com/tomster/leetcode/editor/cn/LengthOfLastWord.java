//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 266 👎 0

package com.tomster.leetcode.editor.cn;
/**
 * @author: tomster
 * @data: 2021-01-09 01:12:41
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //find last char which is not space
        int index1 = s.length() - 1;
        while (index1 != -1 && s.charAt(index1) == ' ') {
            index1--;
        }
        if (index1 == -1) {
            return 0;
        }
        //find last space from index
        int index2 = index1 - 1;
        while (index2 != -1 && s.charAt(index2) != ' ') {
            index2--;
        }
        return index1 - index2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}