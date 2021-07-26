package com.scy.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 类名： CoinPath <br>
 * 描述：
 * 捡金币
 * 【题目】给定一个数组 A[]，每个位置 i 放置了金币 A[i]，小明从 A[0] 出发。当小明走到 A[i] 的时候，下一步他可以选择 A[i+1, i+k]（当然，不能超出数组边界）。
 * 每个位置一旦被选择，将会把那个位置的金币收走（如果为负数，就要交出金币）。请问，最多能收集多少金币？
 *
 * 输入：[1,-1,-100,-1000,100,3], k = 2
 * 输出：4
 *
 * 解释：从 A[0] = 1 出发，收获金币 1。下一步走往 A[2] = -100, 收获金币 -100。再下一步走到 A[4] = 100，收获金币 100，最后走到 A[5] = 3，收获金币 3。
 * 最多收获 1 - 100 + 100 + 3 = 4。没有比这个更好的走法了。 <br>
 * 创建日期： 2021/7/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CoinPath {

    public int maxResult(int[] A, int k) {
        if (A == null || A.length == 0 || k <= 0) return 0;
        int len = A.length;
        int[] ans = new int[len];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            queue.addLast(A[i]);
            // 单调队列中应该是只能保存[i-k, i-1]这个范围
            // 超出范围需要出队 i > k
            if (i - k > 0) {
                if (!queue.isEmpty() && queue.getFirst() == ans[i - k - 1]) {
                    queue.removeFirst();
                }
            }
            // 从单调队列中取得较大值
            int old = queue.isEmpty() ? 0 : queue.getFirst();
            ans[i] = old + A[i];
            while (!queue.isEmpty() && queue.getLast() < ans[i]) {
                queue.removeLast();
            }
            queue.addLast(ans[i]);
        }
        return ans[len - 1];
    }

    class Node {
        // 累计取得的金币!
        int sum = 0;
        // 在index = idx的时候
        // 取得的最大金币为sum
        int idx = 0;
        public Node(int s, int i) {
            sum = s;
            idx = i;
        }
    }

    public int maxResult2(int[] A, int k) {
        // 严格单调递减队列
        // 里面存放的是每个位置可以收集到的金币以及下标index
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        // 走到i位置时，最大的金币收益
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            // 出队！
            // 对于i而言，
            // [i-k, i-1]可以跳到A[i]
            // 最远i - (i - k) = k
            // 因此超出这个范围的，必须要出队
            while (!queue.isEmpty() && i - queue.getFirst().idx > k) {
                queue.removeFirst();
            }
            // 获得在位置i时的收益
            if (queue.isEmpty()) {
                ans = A[i];
            } else {
                ans = queue.getFirst().sum + A[i];
            }
            // 入队，当A[i]入队的时候，要把小于他的那些
            // 收益比他低，又比他旧的给踢除掉
            // 注意！这里使用的是严格的单调递减!
            while (!queue.isEmpty() && queue.getLast().sum <= ans) {
                queue.removeLast();
            }
            queue.addLast(new Node(ans, i));
        }
        return ans;
    }
}