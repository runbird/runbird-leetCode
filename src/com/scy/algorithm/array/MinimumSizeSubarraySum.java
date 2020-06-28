package com.scy.algorithm.array;

/**
 * 类名： MinimumSizeSubarraySum <br>
 * 描述：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *  
 * 进阶：
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）209
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MinimumSizeSubarraySum {

    //方法一
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s == 0) return 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            //一个特点，不从i+1开始
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    count = Math.min(count, j - i + 1);
                    break;
                }
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }


    public static void main(String[] args) {
        MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int[] nums1 = {1, 1};
        int[] nums2 = {10, 2, 3};
        System.out.println(msss.minSubArrayLen(7, nums));
    }
}
