package com.scy.algorithm.dynamicprogramming;

/**
 * 类名： ClimbingStairs <br>
 * 描述：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）70
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ClimbingStairs {

    //方法一 递归 时间复杂度o(n^2)
    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    //方法一 优化时间复杂度到 o(n)
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        if (memo[n] > 0) return memo[n];
        if (n == 1) {
            memo[1] = 1;
        } else if (n == 2) {
            memo[2] = 2;
        } else {
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
        return memo[n];
    }

    //方法三 动态规划，时间 o(n)  空间 o(n)
    public int climbStairs3(int n) {
        if (n == 1) return 1;
        int[] p = new int[n + 1];
        p[1] = 1;
        p[2] = 2;
        for (int i = 3; i <= n; i++) {
            //实际上只需要i -1 和 i-2 这两个数
            //空间复杂度可以用动态数组优化到 o(1)
            p[i] = p[i - 1] + p[i - 2];
        }
        return p[n];
    }

    //方法四 Fibonacci
    public int climbStairs4(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    //    作者：guanpengchn
    //    链接：https://leetcode-cn.com/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
    //    来源：力扣（LeetCode）
    public int climbStairsN(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1);
        return (int) (fib_n / sqrt_5);
    }


    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        cs.climbStairsN(100);
    }
}
