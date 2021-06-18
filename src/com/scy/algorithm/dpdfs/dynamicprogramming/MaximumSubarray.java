package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： MaximumSubarray <br>
 * 描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）53
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MaximumSubarray {

    //    public int maxSubArrayError(int[] nums) {
//        int max = nums[0];
//        List<Integer> arr = new ArrayList<>();
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] + max > max) {
//                max = nums[i] + max;
//            } else {
//                arr.add(max);
//                max = nums[i];
//            }
//        }
//        Optional<Integer> reduce = arr.stream().reduce(Integer::max);
//        return reduce.get();
//    }

    //f(i)=max{f(i−1)+ai,ai}
    public int maxSubArrayFix(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + nums[i - 1] > nums[i]) {
                nums[i] += nums[i - 1];
                max = Math.max(nums[i], max);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int sum = 0 , max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArrayFix(arr));
    }
}
