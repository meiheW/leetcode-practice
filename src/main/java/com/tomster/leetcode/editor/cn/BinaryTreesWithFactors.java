//给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。 
//
// 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。 
//
// 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [2, 4]
//输出: 3
//解释: 可以得到这些二叉树: [2], [4], [4, 2, 2] 
//
// 示例 2: 
//
// 
//输入: arr = [2, 4, 5, 10]
//输出: 7
//解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]. 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 2 <= arr[i] <= 109 
// arr 中的所有值 互不相同 
// 
// Related Topics 数组 哈希表 动态规划 
// 👍 67 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-14 10:59:22
 */
public class BinaryTreesWithFactors {
    public static void main(String[] args) {
        Solution solution = new BinaryTreesWithFactors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFactoredBinaryTrees(int[] arr) {
            Map<Integer, Long> map = new HashMap<>();
            Arrays.sort(arr);
            int n = arr.length;
            int base = (int) Math.pow(10, 9) + 7;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                long sum = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                        sum += map.get(arr[j]) * map.get(arr[i] / arr[j]);
                    }
                }
                map.put(arr[i], sum);
                ans += sum % base;
                ans %= base;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}