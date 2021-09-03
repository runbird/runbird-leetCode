package com.scy.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 类名： SmallestK <br>
 * 描述：设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * <p>
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * 来源：力扣（LeetCode）面试题 17.14. 最小K个数
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/9/3 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SmallestK {

    /**
     * 优先队列-- 小顶堆
     */
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[]{};
        PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> i - j);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
