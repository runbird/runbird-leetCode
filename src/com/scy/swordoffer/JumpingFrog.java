package com.scy.swordoffer;

/**
 * 类名： JumpingFrog <br>
 * 描述：剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 * 0 <= n <= 100 <br>
 *
 * 来源：力扣（LeetCode）剑指 Offer 10- II. 青蛙跳台阶问题
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/9/16 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class JumpingFrog {
    /** 动态规划 */
    public int numWays(int n) {
        if (n == 0) return 1;
        int num = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % num;
        }
        return dp[n];
    }

    /** 滚动法 */
    public int numWays2(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}