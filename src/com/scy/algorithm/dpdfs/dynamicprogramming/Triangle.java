package com.scy.algorithm.dpdfs.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： Triangle <br>
 * 描述：给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）120
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/14 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class Triangle {

    //递归法 f(i,j) = min(f(i+1,j),f(i+1,j+1)) + triangle.get(i).get(j)
    //超时
    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        return reverse(triangle, 0, 0, size);
    }

    private int reverse(List<List<Integer>> triangle, int i, int j, int size) {
        if (i == size) {
            return 0;
        }
        return Math.min(reverse(triangle, i + 1, j, size), reverse(triangle, i + 1, j + 1, size)) + triangle.get(i).get(j);
    }

    //动态规划
    //考虑两个边界问题，最左侧 和 最右侧
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            List<Integer> temp = triangle.get(i);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + temp.get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + temp.get(i);
        }
        int minToal = dp[size - 1][0];
        for (int i = 1; i < size; i++) {
            minToal = Math.min(minToal, dp[size - 1][i]);
        }
        return minToal;
    }

    //方法三 动态规划 空间优化
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();
        int[] dp = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{2},
                                 {3, 4},
                                {6, 5, 7},
                               {4, 1, 8, 3}};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner;
        for (int i = 0; i < nums.length; i++) {
            inner = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                inner.add(nums[i][j]);
            }
            list.add(i,inner);
        }
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal2(list));
    }
}
