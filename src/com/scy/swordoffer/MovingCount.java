package com.scy.swordoffer;

/**
 * 类名： MovingCount <br>
 * 描述：地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *  
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）剑指 Offer 13. 机器人的运动范围
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/5/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MovingCount {

   // private int[][] direction = new int[][]{{1, 0, -1, 0}, {0, 1, 0, -1}};

    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        int result = 0;
        int[][] data = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(data, i, j, k)) result++;
            }
        }
        return result;
    }

    private boolean dfs(int[][] data, int i, int j, int start) {
        if (i < 0 || j < 0 || i >= data.length || j >= data[0].length || data[i][j] != 0) return false;
        data[i][j] = 1;
        int leftV = calcu(i);
        int rightV = calcu(j);
        if ((leftV + rightV) > start) return false;
        boolean res = dfs(data, i + 1, j, start) || dfs(data, i - 1, j, start) || dfs(data, i, j + 1, start) || dfs(data, i, j + 1, start);
        data[i][j] = 0;
        return res;
    }

    private int calcu(int i) {
        int leftV = 0;
        while (i / 10 != 0){
            leftV += i % 10;
            i /= 10;
        }
        leftV += i % 10;
        return leftV;
    }

    public static void main(String[] args) {
        MovingCount mc = new MovingCount();
        System.out.println(mc.movingCount(2, 3, 1));
    }
}
