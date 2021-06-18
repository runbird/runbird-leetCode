package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： SurroundedRegions <br>
 * 描述：给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）130. 被围绕的区域
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/11 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SurroundedRegions {

    //dfs，首先找出边界为O 的元素,并找出连接边界为O的O元素
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        if (n == 0) return;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isBorder = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isBorder && board[i][j] == 'O') {
                    //将边界替换为#
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //注意，需要先替换O为X，再将边界替换为O
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }

            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
