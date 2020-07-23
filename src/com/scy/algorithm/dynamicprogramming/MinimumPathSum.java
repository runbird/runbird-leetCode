package com.scy.algorithm.dynamicprogramming;

/**
 * 类名： MinimumPathSum <br>
 * 描述：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）64
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/23 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                } else {
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        MinimumPathSum mps = new MinimumPathSum();
        System.out.println(mps.minPathSum(grid));
    }
}
