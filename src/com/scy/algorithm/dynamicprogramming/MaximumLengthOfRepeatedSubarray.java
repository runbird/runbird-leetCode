package com.scy.algorithm.dynamicprogramming;

import java.util.jar.JarEntry;

/**
 * 类名： MaximumLengthOfRepeatedSubarray <br>
 * 描述：给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 *
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 提示：
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）718
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/1 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MaximumLengthOfRepeatedSubarray {

    //方法一 暴力破解优化
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    //方法二 滑动窗口
    public int findLength2(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxA = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxA);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxB = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxB);
        }
        return ret;
    }

    private int maxLength(int[] A, int[] B, int addA, int addB, int length) {
        int ret = 0, k = 0;
        for (int i = 0; i < length; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(k, ret);
        }
        return ret;
    }

    //方法三 动态规划
    public int findLength3(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < B.length - 1; j++) {
                if (A[i] == B[i]) {
                    if (i - 1 < 0 || j - 1 < 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (result < dp[i][j]) {
                    result = dp[i][j];
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 1, 4, 7};
        MaximumLengthOfRepeatedSubarray mlrs = new MaximumLengthOfRepeatedSubarray();
        System.out.println(mlrs.findLength(a, b));
    }
}
