package com.scy.algorithm.array;

import java.util.Arrays;

/**
 * @desc: 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * 示例 1：
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * <p>
 * 示例 2：
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * <p>
 * 示例 3：
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * <p>
 * 示例 4：
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * <p>
 * 示例 5：
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 *  
 * 提示：
 * <p>
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 * <p>
 * 来源：力扣（LeetCode）1423
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-02-06 11:38
 **/
public class MaximumPointsYouCcanObtainFromCards {

    /**
     * 滑动数组取值
     */
    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        //滑动数组大小
        int windowSize = length - k;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += cardPoints[i];
        }

        //滑动数组值  若最小 则说明取了最大的k张牌
        int arraySum = Integer.MAX_VALUE;
        for (int i = 0; i < k + 1; i++) {
            int temp = 0;
            // {1,2,3,4,5,6,1} 3
            // {96, 90, 41, 82, 39, 74, 64, 50, 30};
            for (int j = i; j < windowSize + i; j++) {
                temp += cardPoints[j];
            }
            arraySum = Math.min(arraySum, temp);
        }
            return sum - arraySum;
    }

    public int maxScore2(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 滑动窗口大小为 n-k
        int windowSize = n - k;
        // 选前 n-k 个作为初始值
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = windowSize; i < n; ++i) {
            // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }


    public static void main(String[] args) {
        //int[] cardPoints = {96, 90, 41, 82, 39, 74, 64, 50, 30};
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        MaximumPointsYouCcanObtainFromCards m = new MaximumPointsYouCcanObtainFromCards();
        System.out.println(m.maxScore(cardPoints, k));
    }
}
