package com.scy.algorithm.array;

/**
 * 类名： SearchA2dMatrix <br>
 * 描述：编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）74
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/23 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            int midValue = matrix[midIndex / n][midIndex % n];
            if (midValue == target)  return true;
            if (midValue > target) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 13;
        SearchA2dMatrix sm = new SearchA2dMatrix();
        System.out.println(sm.searchMatrix(matrix, target));
    }
}
