package com.scy.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： SpiralOrder <br>
 * 描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）剑指 Offer 29. 顺时针打印矩阵
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/13 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; //从左往右
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; //从上往下
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; //从右往左
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; //从下往上
            if (++l > r) break;
        }
        return res;
    }

    public int[][] test(int n) {
        return new int[][]{{1}};
    }
}
