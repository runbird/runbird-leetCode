package com.scy.swordoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 类名： MaxSlidingWindow <br>
 * 描述：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）剑指 Offer 59 - I. 滑动窗口的最大值
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MaxSlidingWindow {
    // 单调队列使用双端队列来实现
    private Deque<Integer> queue = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            push(nums[i]);
            //数据量不够时继续
            if (i < k - 1) continue;
            ans.add(queue.getFirst());
            pop(nums[i + 1 - k]);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 入队的时候，last方向入队，但是入队的时候
    // 需要保证整个队列的数值是单调的
    // (在这个题里面我们需要是递减的)
    // 并且需要注意，这里是Q.getLast() < val
    // 如果写成Q.getLast() <= val就变成了严格单调递增
    private void push(int k) {
        while (!queue.isEmpty() && queue.getLast() < k) {
            queue.removeLast();
        }
        queue.addLast(k);
    }

    private void pop(int k) {
        if (!queue.isEmpty() && queue.getFirst() == k) {
            queue.removeFirst();
        }
    }


}
