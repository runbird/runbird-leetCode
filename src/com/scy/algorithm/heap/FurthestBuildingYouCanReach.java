package com.scy.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc: 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 *
 * 示例 1：
 * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 输出：4
 *
 * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
 * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
 * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
 * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
 * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
 * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
 *
 * 示例 2：
 * 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * 输出：7
 *
 * 示例 3：
 * 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
 * 输出：3
 *
 * 来源：力扣（LeetCode）1642. 可以到达的最远建筑
 * 链接：https://leetcode-cn.com/problems/furthest-building-you-can-reach
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-07-25 23:57
 **/
public class FurthestBuildingYouCanReach {

    //砖头和梯子都是消耗品
    //思路，用账本needSum记录跨越需要的总数，用优先队列存储各次需要的跨越数
    //用梯子替换堆中最大数
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 注意处理非法输入
        if (heights == null || heights.length == 0) {
            return -1;
        }
        int lastPosition = 0;
        int needSum = 0;
        Queue<Integer> queue = new PriorityQueue<>((i, j) -> j - i);
        int pre = heights[0];
        for (int i = 1; i < heights.length; i++) {
            int cur = heights[i];
            if ( cur <= pre) {
                lastPosition = i;
            } else {
                //记账需要的砖头
                int cost = cur - pre ;
                queue.offer(cost);
                needSum += cost;
                // 如果小本子上的总和比砖块多了 并且还有梯子
                while (bricks < needSum && ladders > 0) {
                    // 需要用梯子把最大的落差给抵消掉
                    needSum -= queue.peek();
                    queue.poll();
                    ladders--;
                }

                if (bricks >= needSum) {
                    lastPosition = i;
                } else {
                    break;
                }
            }
            pre = cur;
        }
        return lastPosition;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,6,20,10,15};
        int bricks = 5, ladders = 1;
        //int[] nums = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        //int bricks = 10, ladders = 2;
        FurthestBuildingYouCanReach fb = new FurthestBuildingYouCanReach();
        System.out.println(fb.furthestBuilding(nums, bricks, ladders));
    }
}
