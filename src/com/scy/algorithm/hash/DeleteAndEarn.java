package com.scy.algorithm.hash;

/**
 * 类名： DeleteAndEarn <br>
 * 描述：给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * 来源：力扣（LeetCode）740. 删除并获得点数
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/9/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        //找出最大数构建一个数组
        //[3,4,2] -> [0,0,2,3,4] 1有0个，2有0个，3有1个。。。
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob2(sum);
    }

    private int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    /**
     * dp空间优化版
     */
    private int rob2(int[] nums) {
        int size = nums.length;
        int a = nums[0], b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        return b;
    }

    private int rob3(int[] nums) {
        int size = nums.length;
        int pre = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}