package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： IntegerBreak <br>
 * 描述：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）343
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/30 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                int left = j * (i - j);
                int right = j * dp[i - j];
                curMax = Math.max(curMax, Math.max(left, right));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new IntegerBreak().integerBreak(4);
    }
}
