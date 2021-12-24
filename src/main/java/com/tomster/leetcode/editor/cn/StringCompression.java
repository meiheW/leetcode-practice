//给你一个字符数组 chars ，请使用下述算法压缩： 
//
// 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ： 
//
// 
// 如果这一组长度为 1 ，则将字符追加到 s 中。 
// 否则，需要向 s 追加字符，后跟这一组的长度。 
// 
//
// 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会
//被拆分为多个字符。 
//
// 请在 修改完输入数组后 ，返回该数组的新长度。 
//
// 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：chars = ["a","a","b","b","c","c","c"]
//输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
//解释：
//"aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
// 
//
// 示例 2： 
//
// 
//输入：chars = ["a"]
//输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
//解释：
//没有任何字符串被替代。
// 
//
// 示例 3： 
//
// 
//输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
//解释：
//由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
//注意每个数字在数组中都有它自己的位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= chars.length <= 2000 
// chars[i] 可以是小写英文字母、大写英文字母、数字或符号 
// 
// Related Topics 双指针 字符串 
// 👍 275 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author: tomster
 * @data: 2021-12-24 22:01:13
 */
public class StringCompression {
    public static void main(String[] args) {
        Solution solution = new StringCompression().new Solution();
        int ans = solution.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int compress(char[] chars) {
            int p0 = 0, p1 = 0, n = chars.length;
            int index = 0;//标记修改位置
            while (p0 < n) {
                p1 = p0 + 1;
                while (p1 < n && chars[p1] == chars[p0]) {
                    p1++;
                }
                //修改原数组
                chars[index++] = chars[p0];
                int count = p1 - p0;
                if (count > 1) {
                    String s = String.valueOf(count);
                    for (int i = 0; i < s.length(); i++) {
                        chars[index++] = s.charAt(i);
                    }
                }
                //指针前移
                p0 = p1;
            }
            return index;
        }


        //输入：chars = ["a","a","b","b","c","c","c"]
        //输出：返回 6 ，["a","2","b","2","c","3"]
        //2021/12/24  怎么都没之前代码写的优雅了呢
        public int compress1(char[] chars) {
            int index = 0;//覆盖原数组的指针
            int p = 1;
            int cnt = 1;
            while (p < chars.length) {
                if (chars[p] != chars[p - 1]) {
                    chars[index++] = chars[p - 1];
                    if (cnt != 1) {
                        //写数目
                        char[] arr = String.valueOf(cnt).toCharArray();
                        System.arraycopy(arr, 0, chars, index, arr.length);
                        index += arr.length;
                    }
                    cnt = 1;
                } else {
                    cnt++;
                }
                p++;
            }
            chars[index++] = chars[p - 1];
            if (cnt != 1) {
                //写数目
                char[] arr = String.valueOf(cnt).toCharArray();
                System.arraycopy(arr, 0, chars, index, arr.length);
                index += arr.length;
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}