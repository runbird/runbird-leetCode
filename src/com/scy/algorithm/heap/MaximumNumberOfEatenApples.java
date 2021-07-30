package com.scy.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 类名： MaximumNumberOfEatenApples <br>
 * 描述：有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，
 * 这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，
 * 此时用 apples[i] == 0 且 days[i] == 0 表示。
 * <p>
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 * 示例 1：
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * <p>
 * 示例 2：
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 * <p>
 * 来源：力扣（LeetCode）1705. 吃苹果的最大数目
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MaximumNumberOfEatenApples {
    class Node {
        // 记录果子数目
        public int num;
        // 记录哪天会坏掉
        public int bad;

        public Node(int num, int bad) {
            this.num = num;
            this.bad = bad;
        }
    }

    public int eatenApples(int[] apples, int[] days) {
        if (apples == null || days == null || apples.length == 0 || days.length == 0) return 0;
        int ans = 0, i = 1, len = apples.length;
        // Queue<Node> queue = new PriorityQueue<>((a, b) -> a.bad - b.bad);
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.bad));
        while (i <= len || !queue.isEmpty()) {
            if (i <= len) {
                int num = apples[i - 1];
                int bad = i + days[i - 1];
                if (num > 0) {
                    queue.offer(new Node(num, bad));
                }
            }
            // 把已经过期的都扔掉
            while (!queue.isEmpty() && (queue.peek().bad <= i)) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                Node cur = queue.poll();
                ans++;
                if (--cur.num > 0) {
                    queue.offer(cur);
                }
            }
            i++;
        }
        return ans;
    }
}
