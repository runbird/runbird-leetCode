package com.scy.swordoffer;

/**
 * 类名： NumWays <br>
 * 描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
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
 * 来源：力扣（LeetCode）剑指 Offer 10- II. 青蛙跳台阶问题
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/5/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class NumWays {
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

    //因为每次只需要前两个值相加，可以进一步优化空间
    public int numWays2(int n) {
        int cur = 1, nxt = 1;
        for(int i = 0; i < n; i++){
            int tmp = nxt;
            nxt = (cur + nxt) % 1000000007;
            cur = tmp;
        }
        return cur;
    }

}
