package com.scy.algorithm.array;

/**
 * 类名： SpiralMmatrixII <br>
 * 描述：
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 * <p>
 * 来源：力扣（LeetCode）59
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/3/17 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SpiralMmatrixII {
    public int[][] generateMatrix(int n) {
        //右下左上
        int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[n][n];
        int count = n * n, start = 1;
        int row = 0, column = 0, directionIndex = 0;
        while (start <= count) {
            result[row][column] = start;
            start++;
            int nextRow = row + direct[directionIndex][0];
            int nextColumn = column + direct[directionIndex][1];
            if (nextColumn < 0 || nextColumn >= n || nextRow < 0 || nextRow >= n || result[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direct[directionIndex][0];
            column += direct[directionIndex][1];
        }
        return result;
    }

    //By Myself
    public int[][] generateMatrix2(int n) {
        if(n == 1) return new int[][]{{1}};
        int[][] ans = new int[n][n];
        int l = 0, r = n - 1, t = 0 , b = n - 1, x = 0;
        while(true){
            for(int i = l; i <= r; i++) ans[t][i] = ++x;
            if(++t > b) break;
            for(int i = t; i <= b; i++) ans[i][r] = ++x;
            if(--r < l) break;
            for(int i = r; i >= l; i--) ans[b][i] = ++x;
            if(--b < t) break;
            for(int i = b; i >= t; i--) ans[i][l] = ++x;
            if(++l > r) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralMmatrixII spiralMmatrixII = new SpiralMmatrixII();
        int[][] s = spiralMmatrixII.generateMatrix(3);
    }
}
