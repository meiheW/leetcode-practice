//有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。 
//
// 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。 
//
// 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。 
//
// 
//
// 示例： 
//
// 
//输入： p = 2, q = 1
//输出： 2
//解释： 这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= p <= 1000 
// 0 <= q <= p 
// 
// Related Topics 几何 数学 
// 👍 60 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-11-27 21:36:03
 */
public class MirrorReflection {
    public static void main(String[] args) {
        Solution solution = new MirrorReflection().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mirrorReflection(int p, int q) {
            int g = gcd(p, q);
            p /= g;
            p %= 2;
            q /= g;
            q %= 2;

            if (p == 1 && q == 1) {
                return 1;
            } else {
                return p == 1 ? 0 : 2;
            }


        }

        private int gcd(int a, int b) {
            return a != 0 ? gcd(b % a, a) : Math.abs(b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}