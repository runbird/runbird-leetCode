package com.scy.algorithm.dynamicprogramming;

/**
 * 类名： InterleavingString <br>
 * 描述：给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 *
 * 示例 2:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 * 来源：力扣（LeetCode）97
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/18 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class InterleavingString {

    //动态规划
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) return false;
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n2 && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i + j - 1) == s3.charAt(i - 1) ||
                        dp[i][j - 1] && s2.charAt(i + j - 1) == s3.charAt(j - 1));
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave(s1, s2, s3));
    }
}
