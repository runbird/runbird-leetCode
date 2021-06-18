package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： BestTimeToBuyAndSellStockWithCooldown <br>
 * 描述：给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）309
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商3业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/10 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    //方法一 动态规划
    //     dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i]);//对于持股状态，我们要么是之前持有的股份没有卖，要么就是冷冻期不持股，冷冻期过了新买的。
    //     dp[i][1] = dp[i - 1][0] + prices[i];//对于不持股且在冷冻期，我们肯定是持有股票并且卖了股票，所以有收益。
    //     dp[i][2] = max(dp[i - 1][1], dp[i - 1][2]);//对于不持股且不在冷冻期，说明我们在i-1天不持有股票，不持有股票有两种状态（在不在冷冻期）。
    //
    //作者：xiao-xin-28
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/javazui-rong-yi-li-jie-de-dong-tai-gui-hua-chu-xue/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            //对于持股状态，我们要么是之前持有的股份没有卖，要么就是冷冻期不持股，冷冻期过了新买的。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            //对于不持股且在冷冻期，我们肯定是持有股票并且卖了股票，所以有收益。
            dp[i][1] = dp[i - 1][0] + prices[i];
            //对于不持股且不在冷冻期，说明我们在i-1天不持有股票，不持有股票有两种状态（在不在冷冻期）。
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        //最后对不持股状态求最大，因为持股是没有意义的，只能是利润减少。
        return Math.max(dp[n - 1][2], dp[n - 1][1]);
    }

    //空间优化
    public int maxProfitPro(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] dp = new int[3];
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[1] = Math.max(dp[1], dp[2] - prices[i]);
            dp[2] = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        }
        return Math.max(dp[0], dp[1]);
    }



    public static void main(String[] args) {

    }
}
