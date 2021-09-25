//我们有一个项的集合，其中第 i 项的值为 values[i]，标签为 labels[i]。 
//
// 我们从这些项中选出一个子集 S，这样一来： 
//
// 
// |S| <= num_wanted 
// 对于任意的标签 L，子集 S 中标签为 L 的项的数目总满足 <= use_limit。 
// 
//
// 返回子集 S 的最大可能的 和。 
//
// 
//
// 示例 1： 
//
// 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
//输出：9
//解释：选出的子集是第一项，第三项和第五项。
// 
//
// 示例 2： 
//
// 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
//输出：12
//解释：选出的子集是第一项，第二项和第三项。
// 
//
// 示例 3： 
//
// 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
//输出：16
//解释：选出的子集是第一项和第四项。
// 
//
// 示例 4： 
//
// 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
//输出：24
//解释：选出的子集是第一项，第二项和第四项。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= values.length == labels.length <= 20000 
// 0 <= values[i], labels[i] <= 20000 
// 1 <= num_wanted, use_limit <= values.length 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 
// 👍 19 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.*;

/**
 * @author: tomster
 * @data: 2021-09-25 16:01:50
 */
public class LargestValuesFromLabels {
    public static void main(String[] args) {
        Solution solution = new LargestValuesFromLabels().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            int n = values.length;
            List<ValueLabel> valueLabelList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                valueLabelList.add(new ValueLabel(values[i], labels[i]));
            }
            Collections.sort(valueLabelList);
            Map<Integer, Integer> labelCountMap = new HashMap<>();
            int index = 0;
            int numCounted = 0;
            int ans = 0;
            while (numCounted < numWanted && index < n) {
                ValueLabel vl = valueLabelList.get(index);
                Integer label = vl.label;
                Integer labelCount = labelCountMap.getOrDefault(label, 0);
                if (labelCount != useLimit) {
                    labelCountMap.put(label, labelCount + 1);
                    ans += vl.val;
                    numCounted++;
                }
                index++;
            }
            return ans;
        }

        class ValueLabel implements Comparable<ValueLabel> {
            int val;
            int label;

            ValueLabel(int val, int label) {
                this.val = val;
                this.label = label;
            }

            @Override
            public int compareTo(ValueLabel o) {
                //reverse
                return Integer.compare(o.val, this.val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}