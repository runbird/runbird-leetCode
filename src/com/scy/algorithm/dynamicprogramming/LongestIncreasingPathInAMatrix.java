package com.scy.algorithm.dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名： LongestIncreasingPathInAMatrix <br>
 * 描述：给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 * 示例 2:
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class LongestIncreasingPathInAMatrix {
    //记录新的下一个元素移动方向，+ - 1
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int row, int column, int[][] memo) {
        //已经计算过
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        // 未记录过的位置，能访问到的路径至少为1
        memo[row][column]++;
        //将方向存入数组，并遍历4个方向
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            //只要不相等就进行dfs    关键：只找递增的路径，进行下探（因为只找的递增，所以保证了不会往回跑）
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo)+1);
            }
        }
        return memo[row][column];
    }


    //方法二 拓扑排序
    //    链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] outdegrees = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                for (int[] dir : dirs) {
                    int newRow = i + dir[0], newColumn = j + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j]) {
                        ++outdegrees[i][j];
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (outdegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newColumn = column + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] < matrix[row][column]) {
                        --outdegrees[newRow][newColumn];
                        if (outdegrees[newRow][newColumn] == 0) {
                            queue.offer(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
        return ans;
    }
}

class DPSolutionDemo{
    //链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/pu-pu-tong-tong-de-shen-du-you-xian-ji-yi-hua-de-m/
    // 在遍历过程中记录每个点递增能到达的最长路径的最大值，可以省去最后对max数组遍历取最大；
    private int longest;
    // 方向数组，路径问题必备
    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        // 用二维数组也可以，没太大区别，占用空间都是m * n
        int[] max = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 对于已经访问并记录了最大递增路径的节点，直接跳过；
                if (max[i * n + j] == 0) {
                    _longestIncreasingPath(matrix, max, i, j, m, n);
                }
            }
        }
        return longest;
    }

    // 找到（x, y）节点能访问到的最大路径，期间记录到max中；
    private int _longestIncreasingPath(int[][] matrix, int[] max, int x, int y, int m, int n) {
        //terminator 遇到有记录过的最大路径 直接返回路径
        int index = x * n + y;
        if (max[index] != 0) return max[index];
        // 未记录过的位置，能访问到的路径至少为1
        max[index] = 1;
        for (int[] dir : directions) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            // 关键：只找递增的路径，进行下探（因为只找的递增，所以保证了不会往回跑）
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && matrix[x][y] < matrix[nextX][nextY]) {
                max[index] = Math.max(max[index], _longestIncreasingPath(matrix, max, nextX, nextY, m, n) + 1);
            }
        }
        longest = Math.max(longest, max[index]);
        return max[index];
    }
}