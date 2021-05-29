package com.scy.algorithm.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 *  
 *
 * 示例 1：
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 *
 * 示例 2：
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 *
 * 示例 3：
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 *
 * 来源：力扣（LeetCode） 1074
 * 链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-05-29 23:59
 **/
public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length , n = matrix[0].length;
        //枚举上边界
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            //枚举下边界
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] = matrix[i][j];
                }
                ans += subArraySum(sum, target);
            }
        }
        return ans;
    }

    private int subArraySum(int[] sum, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        dict.put(0, 1);
        int count = 0, pre = 0;
        for (int i : sum) {
            pre += i;
            if (dict.containsKey(pre - target)) {
                count += dict.get(pre - target);
            }
            dict.put(pre, dict.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
