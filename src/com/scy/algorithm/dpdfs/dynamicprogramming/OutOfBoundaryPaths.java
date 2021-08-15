package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 *
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * 示例 2：
 *
 *
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 *
 * 来源：力扣（LeetCode）576. 出界的路径数
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OutOfBoundaryPaths {
    int mod = (int) 1e9 + 7;
    int r, c, max;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        r = m;
        c = n;
        max = maxMove;
        int[][] f = new int[r * c][max + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0) add(i, j, f);
                if (j == 0) add(i, j, f);
                if (i == r - 1) add(i, j, f);
                if (j == c - 1) add(i, j, f);
            }
        }

        for (int k = 1; k <= max; k++) {
            for (int idx = 0; idx < r * c; idx++) {
                int[] info = parseIdx(idx);
                int x = info[0], y = info[1];
                for (int[] d : dir) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    int nidx = getId(nx, ny);
                    f[idx][k] += f[nidx][k - 1];
                    f[idx][k] %= mod;
                }
            }
        }
        return f[getId(startRow, startColumn)][max];
    }

    void add(int x, int y, int[][] f) {
        for (int k = 1; k <= max; k++) {
            f[getId(x, y)][k]++;
        }
    }

    int getId(int x, int y) {
        return x * c + y;
    }

    int[] parseIdx(int idx) {
        return new int[]{idx / c, idx % c};
    }
}
