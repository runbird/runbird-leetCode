package com.scy.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * 类名： DungeonGame <br>
 * 描述：一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2(K)  -3	3
 * -5	  -10	1
 * 10     30    -5(P)
 *  
 * 说明:
 * 骑士的健康点数没有上限。
 *
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * 来源：力扣（LeetCode）174
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/12 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class DungeonGame {

    //最后一个格子 dp[m-1][n-1] = max(1, 1 - dungeon[m-1][n-1])
    //最后一行     dp[m-1][j] = max(1, dp[m-1][j+1] - dungeon[m-1][j])
    //最后一列     dp[i][n-1] = max(1, dp[i+1][n-1] - dungeon[i][n-1])
    //中间的格子   dp[i][j] = max(1, min(dp[i][j+1] ,dp[i+1][j]) - dungeon[i][j])
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        //最后一行
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = Math.max(1, dp[j + 1] - dungeon[m - 1][j]);
        }
        //最后一列
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = Math.max(1, dp[n - 1] - dungeon[i][n - 1]);
            //中间
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(1, Math.min(dp[j + 1], dp[j]) - dungeon[i][j]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] nums = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        DungeonGame dg = new DungeonGame();
        System.out.println(dg.calculateMinimumHP(nums));
    }

}
