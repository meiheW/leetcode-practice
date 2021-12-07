//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
// Related Topics 数学 字符串 
// 👍 40 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-12-07 22:28:58
 */
public class NumberOfDaysBetweenTwoDates {
    public static void main(String[] args) {
        Solution solution = new NumberOfDaysBetweenTwoDates().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int daysBetweenDates(String date1, String date2) {
            return date2.compareTo(date1) > 0 ? daysGap(date1, date2) : daysGap(date2, date1);
        }

        private int daysGap(String date1, String date2) {
            int year1 = Integer.parseInt(date1.substring(0, 4));
            int year2 = Integer.parseInt(date2.substring(0, 4));
            int sum = 0;
            for (int i = year1; i < year2; i++) {
                sum += isLeapYear(i) ? 366 : 365;
            }
            sum -= dayOfYear(date1);
            sum += dayOfYear(date2);
            return sum;
        }

        private int dayOfYear(String date) {
            int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8));
            if (isLeapYear(year)) {
                days[1] = 29;
            }
            int sum = 0;
            for (int i = 0; i < month - 1; i++) {
                sum += days[i];
            }
            sum += day;
            return sum;
        }

        private boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}