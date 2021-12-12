//n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
// 
// 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1） 
// 第一个整数是 0 
// 一个整数在序列中出现 不超过一次 
// 每对 相邻 整数的二进制表示 恰好一位不同 ，且 
// 第一个 和 最后一个 整数的二进制表示 恰好一位不同 
// 
//
// 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：[0,1,3,2]
//解释：
//[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
//- 00 和 01 有一位不同
//- 01 和 11 有一位不同
//- 11 和 10 有一位不同
//- 10 和 00 有一位不同
//[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
//- 00 和 10 有一位不同
//- 10 和 11 有一位不同
//- 11 和 01 有一位不同
//- 01 和 00 有一位不同
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 
// Related Topics 位运算 数学 回溯 
// 👍 357 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tomster
 * @data: 2021-12-12 19:27:30
 */
public class GrayCode {
    public static void main(String[] args) {
        Solution solution = new GrayCode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：n = 2 输出：[0,1,3,2]
        //解释：[0,1,3,2] 的二进制表示是 [00,01,11,10]
        //这是格雷编码的镜像反射法
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            int head = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = ans.size() - 1; j >= 0; j--) {
                    ans.add(ans.get(j) + head);
                }
                head <<= 1;
            }
            return ans;
        }

        //我的方法超时了
        /*List<Integer> mask;

        int total = 0;

        public List<Integer> grayCode(int n) {
            mask = getMask(n);
            total = (int) Math.pow(2, n);
            return backTracing(new ArrayList<>(), 0);
        }

        private List<Integer> backTracing(List<Integer> temp, int addNum) {
            temp.add(addNum);
            if (temp.size() == total && mask.contains(addNum)) {
                return temp;
            }
            for (int i = 0; i < mask.size(); i++) {
                int next = addNum ^ mask.get(i);
                if (!temp.contains(next)) {
                    List<Integer> res = backTracing(temp, next);
                    if (res != null) {
                        return temp;
                    }
                }
            }
            temp.remove(temp.size() - 1);
            return null;
        }

        private List<Integer> getMask(int n) {
            List<Integer> mask = new ArrayList<>();
            mask.add(1);
            for (int i = 1; i < n; i++) {
                mask.add(1 << i);
            }
            return mask;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}