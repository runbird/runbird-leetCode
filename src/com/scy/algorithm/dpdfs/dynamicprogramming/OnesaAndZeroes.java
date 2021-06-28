package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： OnesaAndZeroes <br>
 * 描述：给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 *
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2
 *
 * 来源：力扣（LeetCode）474
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/6/8 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class OnesaAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            int zero =0 , one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero ++;
                } else {
                    one++;
                }
            }
            cnt[i] = new int[]{zero, one};
        }
        // 代表考虑前 k 件物品，在数字 1 容量不超过 i，数字 0 容量不超过 j 的条件下的「最大价值」（每个字符串的价值均为 1）。
        int[][][] f = new int[len + 1][m + 1][n + 1];
        for (int k = 1; k <= len; k++) {
            int zero = cnt[k - 1][0], one = cnt[k - 1][1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int a = f[k - 1][i][j];
                    int b = (i >= zero && j >= one) ? f[k - 1][i - zero][j - one] + 1 : 0;
                    f[k][i][j] = Math.max(a, b);
                }
            }
        }
        return f[len][m][n];
    }

    //
    public int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            int[] cnt = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zero = cnt[0];
                    int one = cnt[1];
                    if (j >= zero && k >= one) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }
}
