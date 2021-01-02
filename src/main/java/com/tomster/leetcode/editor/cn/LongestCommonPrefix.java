//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1401 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-01-02 20:38:33
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            } else if (strs.length == 1) {
                return strs[0];
            } else {
                //两个及以上
                for(int i=0; i<strs[0].length(); i++){
                    boolean flag = true;
                    char c = strs[0].charAt(i);
                    for(int j=1; j<strs.length; j++){
                        if(strs[j].length()==i || c != strs[j].charAt(i)){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag){
                        return strs[0].substring(0,i);
                    }
                }
                return strs[0];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}