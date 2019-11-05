package com.scy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {


    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            //去除重复元素
            if (i == 0 || nums[i] != nums[i - 1]) {
                //创建两个指针
                int j = i + 1;
                int r = nums.length - 1;
                int sum = -nums[i];
                while (j < r) {
                    if (sum == nums[j] + nums[r]) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[r]));
                        // 缩小范围
                        while (j < r && nums[j] == nums[j + 1]) j++;
                        while (j < r && nums[r] == nums[r - 1]) r--;
                        j++;
                    } else if (sum > nums[j] + nums[r]) {
                        while (j < r && nums[j] == nums[j + 1]) j++;
                        j++;
                    } else {
                        while (j < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> lists = ThreeSum.threeSum(nums);
        System.out.println(lists);
    }
}
