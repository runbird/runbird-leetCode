package com.scy.algorithm.math;

/**
 * 类名： MaxPointsOnALine <br>
 * 描述：给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 * 示例 1：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 *
 * 示例 2：
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *
 * 来源：力扣（LeetCode）149. 直线上最多的点数
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/6/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j];
                int cnt = 2;
                for (int k = j+1; k < n; k++) {
                    int[] p = points[k];
                    int s1 = (p[1]-y[1]) * (y[0] - x[0]);
                    int s2 = (y[1] - x[1]) *(p[0] - y[0]);
                    if (s1 == s2 ) cnt ++;
                }
                ans = Math.max(cnt, ans);
            }
        }
        return ans;
    }
}
