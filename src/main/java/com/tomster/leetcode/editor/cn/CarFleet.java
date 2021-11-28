//N 辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
//
// 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
//
// 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
//
// 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
//
// 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
//
// 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
//
//
//
// 会有多少车队到达目的地?
//
//
//
// 示例：
//
// 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//输出：3
//解释：
//从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
//从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
//从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
//请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
//
//
//
//提示：
//
//
// 0 <= N <= 10 ^ 4
// 0 < target <= 10 ^ 6
// 0 < speed[i] <= 10 ^ 6
// 0 <= position[i] < target
// 所有车的初始位置各不相同。
//
// Related Topics 数组 排序
// 👍 124 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author: tomster
 * @data: 2021-11-28 14:09:22
 */
public class CarFleet {
    public static void main(String[] args) {
        Solution solution = new CarFleet().new Solution();
        int i = solution.carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单调栈清晰明了，但是速度也很慢
         * 执行耗时:167 ms,击败了19.38% 的Java用户
         * 内存消耗:110.5 MB,击败了19.16% 的Java用户
         */
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            int[][] carPoint = new int[n][2];
            for (int i = 0; i < n; i++) {
                carPoint[i][0] = position[i];
                carPoint[i][1] = speed[i];
            }
            Arrays.sort(carPoint, Comparator.comparingInt(o -> o[0]));
            Stack<Float> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                float t = (target - carPoint[i][0]) * 1.0f / carPoint[i][1];
                while (!stack.isEmpty() && stack.peek() <= t) {
                    stack.pop();
                }
                stack.push(t);
            }
            return stack.size();

        }

        /**
         * 我的弟弟解法
         * 执行耗时:131 ms,击败了34.84% 的Java用户
         * 内存消耗:105.3 MB,击败了34.97% 的Java用户
         */
        public int carFleet1(int target, int[] position, int[] speed) {
            int n = position.length;
            int[][] carPoint = new int[n][2];
            for (int i = 0; i < n; i++) {
                carPoint[i][0] = position[i];
                carPoint[i][1] = speed[i];
            }
            Arrays.sort(carPoint, Comparator.comparingInt(o -> o[0]));
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                int curPosition = carPoint[i][0];
                int curSpeed = carPoint[i][1];
                boolean catched = false;
                for (int j = i + 1; j < n; j++) {
                    int p = carPoint[j][0];
                    int s = carPoint[j][1];
                    if (s >= curSpeed) {
                        continue;
                    }
                    //int curT = (target - curPosition) / curSpeed;
                    //int t = (target - p) / s;
                    //if (curT <= t) {
                    if ((long) (target - curPosition) * s <= (long) (target - p) * curSpeed) {
                        catched = true;
                        break;
                    }
                }
                if (!catched) {
                    ans++;
                }
            }
            return ans + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}