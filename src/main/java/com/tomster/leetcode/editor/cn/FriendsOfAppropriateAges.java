//人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。 
//
// 当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求： 
//
// 
// age[B] <= 0.5 * age[A] + 7 
// age[B] > age[A] 
// age[B] > 100 && age[A] < 100 
// 
//
// 否则，A 可以给 B 发送好友请求。 
//
// 注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 
//
// 求总共会发出多少份好友请求? 
//
// 
//
// 示例 1： 
//
// 
//输入：[16,16]
//输出：2
//解释：二人可以互发好友申请。
// 
//
// 示例 2： 
//
// 
//输入：[16,17,18]
//输出：2
//解释：好友请求可产生于 17 -> 16, 18 -> 17. 
//
// 示例 3： 
//
// 
//输入：[20,30,100,110,120]
//输出：3
//解释：好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ages.length <= 20000 
// 1 <= ages[i] <= 120 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 69 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-28 14:04:02
 */
public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        Solution solution = new FriendsOfAppropriateAges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //age[B] > 0.5 * age[A] + 7
        //age[B] <= age[A]
        //~(age[B] > 100 && age[A] < 100)
        public int numFriendRequests(int[] ages) {
            int[] count = new int[121];
            for (int age : ages) count[age]++;

            int ans = 0;
            for (int ageA = 0; ageA <= 120; ageA++) {
                int countA = count[ageA];
                for (int ageB = 0; ageB <= 120; ageB++) {
                    int countB = count[ageB];
                    if (ageA * 0.5 + 7 >= ageB) continue;
                    if (ageA < ageB) continue;
                    if (ageA < 100 && 100 < ageB) continue;
                    ans += countA * countB;
                    if (ageA == ageB) ans -= countA;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}