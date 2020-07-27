package com.scy.algorithm.array;

/**
 * 类名： SearchA2dMatrixII <br>
 * 描述：编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）240
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SearchA2dMatrixII {
    //暴力法
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        if (n < 1) return false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (target == matrix[i][j])
                    return true;
            }
        }
        return false;
    }

    //暴力法 优化
    public boolean searchMatrixPro(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        if (target > matrix[rows-1][columns-1] || target < matrix[0][0]){
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (target == matrix[i][j])
                    return true;
            }
        }
        return false;
    }

    /**
     * 选左上角，往右走和往下走都增大，不能选
     * 选右下角，往上走和往左走都减小，不能选
     * 选左下角，往右走增大，往上走减小，可选
     * 选右上角，往下走增大，往左走减小，可选
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = rows - 1, column = 0;
        while (row >= 0 && column < columns) {
            if (matrix[row][column] < target) {
                column++;
            } else if (matrix[row][column] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
