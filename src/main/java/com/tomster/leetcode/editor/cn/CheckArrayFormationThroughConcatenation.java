//给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pi
//eces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。 
//
// 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [85], pieces = [[85]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：arr = [15,88], pieces = [[88],[15]]
//输出：true
//解释：依次连接 [15] 和 [88]
// 
//
// 示例 3： 
//
// 
//输入：arr = [49,18,16], pieces = [[16,18,49]]
//输出：false
//解释：即便数字相符，也不能重新排列 pieces[0]
// 
//
// 示例 4： 
//
// 
//输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//输出：true
//解释：依次连接 [91]、[4,64] 和 [78] 
//
// 示例 5： 
//
// 
//输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pieces.length <= arr.length <= 100 
// sum(pieces[i].length) == arr.length 
// 1 <= pieces[i].length <= arr.length 
// 1 <= arr[i], pieces[i][j] <= 100 
// arr 中的整数 互不相同 
// pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同） 
// 
// Related Topics 排序 数组 哈希表 
// 👍 26 👎 0

package com.tomster.leetcode.editor.cn;

/**
 * @author: tomster
 * @data: 2021-05-15 23:12:17
 */
public class CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        Solution solution = new CheckArrayFormationThroughConcatenation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            int piecesNum = 0;
            for (int[] piece : pieces) {
                piecesNum += piece.length;
                if (!arrContainsPieces(arr, piece)) {
                    return false;
                }
            }
            return arr.length == piecesNum;
        }

        private boolean arrContainsPieces(int[] arr, int[] piece) {
            if (arr == null || piece == null || arr.length < piece.length) {
                return false;
            }
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == piece[0]) {
                    index = i;
                    break;
                }
            }
            if (arr.length - index < piece.length) {
                return false;
            }
            for (int i = 0; i < piece.length; i++) {
                if (piece[i] != arr[index + i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}