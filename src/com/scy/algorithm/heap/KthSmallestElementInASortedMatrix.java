package com.scy.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 类名： KthSmallestElementInASortedMatrix <br>
 * 描述：给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例：
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * 来源：力扣（LeetCode）378
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/2 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(n * n, (a, b) -> a - b);
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                queue.add(ints[j]);
            }
        }
        for (int i = 1; i <= k - 1; i++) {
            queue.poll();
        }
        return queue.peek() == null ? -1 : queue.peek();
    }

    //进一步优化 归并排序
   // 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
   //TODO
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.peek() == null ? -1 : pq.peek()[0];
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9},
                          {10, 11, 13},
                          {12, 13, 15}};
        KthSmallestElementInASortedMatrix ksei = new KthSmallestElementInASortedMatrix();
        System.out.println(ksei.kthSmallest(matrix,8));
    }
}
