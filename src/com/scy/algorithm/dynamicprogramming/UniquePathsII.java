package com.scy.algorithm.dynamicprogramming;

/**
 * 类名： UniquePathsII <br>
 * 描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 *
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）63
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class UniquePathsII {

    /*  当坐标 (i, j) 本身有障碍的时候，任何路径都到到不了 f(i, j)，此时 f(i, j) = 0；
        f(i, j) = f(i,j-1)+f(i-1,j)
        很显然我们可以给出一个时间复杂度 O(nm) 并且空间复杂度也是 O(nm)的实现，由于这里 f(i, j) 只与 f(i - 1, j)和 f(i, j - 1) 相关，
        我们可以运用「滚动数组思想」把空间复杂度优化称O(m)。
        */
    //链接：https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && ints[j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        int[][] path = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII up2 = new UniquePathsII();
        System.out.println(up2.uniquePathsWithObstacles2(path));
    }
}
