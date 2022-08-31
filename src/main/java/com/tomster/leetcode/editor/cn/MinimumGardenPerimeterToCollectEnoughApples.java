/**
 * 给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。
 * <p>
 * 你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。
 * <p>
 * 给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。
 * <p>
 * |x| 的值定义为：
 * <p>
 * <p>
 * 如果 x >= 0 ，那么值为 x
 * 如果 x < 0 ，那么值为 -x
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：neededApples = 1
 * 输出：8
 * 解释：边长长度为 1 的正方形不包含任何苹果。
 * 但是边长为 2 的正方形包含 12 个苹果（如上图所示）。
 * 周长为 2 * 4 = 8 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：neededApples = 13
 * 输出：16
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：neededApples = 1000000000
 * 输出：5040
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= neededApples <= 10¹⁵
 * <p>
 * Related Topics 数学 二分查找 👍 19 👎 0
 */
package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2022-08-31 17:32:10
 */
public class MinimumGardenPerimeterToCollectEnoughApples {
    public static void main(String[] args) {
        Solution solution = new MinimumGardenPerimeterToCollectEnoughApples().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //假设右上角的角为(n,n)，则周长8n
        public long minimumPerimeter(long neededApples) {
            long low = 1, high = (long) Math.ceil(Math.cbrt(neededApples));
            while (low < high) {
                long mid = low + (high - low) / 2;
                long count = 2 * mid * (mid + 1) * (2 * mid + 1);
                if (count >= neededApples) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return high * 8;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}