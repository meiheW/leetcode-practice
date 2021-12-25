//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 
//输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 
//输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 示例 3： 
//
// 
//输入：name = "leelee", typed = "lleeelee"
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
// 
//
// 提示： 
//
// 
// name.length <= 1000 
// typed.length <= 1000 
// name 和 typed 的字符都是小写字母。 
// 
//
// 
//
// 
// Related Topics 双指针 字符串 
// 👍 217 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-25 22:37:41
 */
public class LongPressedName {
    public static void main(String[] args) {
        Solution solution = new LongPressedName().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isLongPressedName(String name, String typed) {
            int p0 = 0, p1 = 0;
            //循环条件：就是遍历整个typed
            while (p1 < typed.length()) {
                //如果对应字符相等
                if (p0 < name.length() && name.charAt(p0) == typed.charAt(p1)) {
                    p0++;
                    p1++;
                } else if (p1 > 0 && typed.charAt(p1 - 1) == typed.charAt(p1)) {
                    //如果不相等，但是现在的前后一致
                    p1++;
                } else {
                    //其余情况直接返回错误，不管p0有没有到最后
                    return false;
                }
            }
            return p0 == name.length();
        }

        //和官方题解的思路是一样的，但是考虑边界问题思路不一样导致代码很复杂
        public boolean isLongPressedName1(String name, String typed) {
            int p0 = 0, p1 = 0;
            int n0 = name.length(), n1 = typed.length();
            //这个很关键，由于这么设置循环条件，所以边界条件考虑就复杂了
            while (p0 < n0 && p1 < n1) {
                if (name.charAt(p0) == typed.charAt(p1)) {
                    p0++;
                    p1++;
                } else {
                    if (p1 > 0 && typed.charAt(p1) == typed.charAt(p1 - 1)) {
                        p1++;
                    } else {
                        return false;
                    }
                }
            }
            //同时到终点
            if (p0 == n0 && p1 == n1) {
                return true;
            }
            //后者先到终点，那肯定是错的
            if (p1 == n1) {
                return false;
            }
            //前者先到终点，那么后者后面的字符必定和最后一个字符一样
            for (int i = p1; i < n1; i++) {
                if (typed.charAt(i - 1) != typed.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}