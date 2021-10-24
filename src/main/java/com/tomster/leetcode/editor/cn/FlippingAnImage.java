//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。 
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。 
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。 
//
// 
//
// 示例 1： 
//
// 
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = A[0].length <= 20 
// 0 <= A[i][j] <= 1 
// 
// Related Topics 数组 双指针 矩阵 模拟 
// 👍 262 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-10-24 13:22:45
 */
public class FlippingAnImage {
    public static void main(String[] args) {
        Solution solution = new FlippingAnImage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] flipAndInvertImage(int[][] image) {

            int n = image[0].length;
            //翻转每行
            for (int[] row : image) {
                for (int i = 0; i < n / 2; i++) {
                    swap(row, i, n - 1 - i);
                }
            }
            //反转图像
            for (int[] row : image) {
                for (int i = 0; i < n; i++) {
                    row[i] ^= 1;
                }
            }
            return image;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}