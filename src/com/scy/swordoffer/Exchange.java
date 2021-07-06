package com.scy.swordoffer;

/**
 * 类名： Exchange <br>
 * 描述：TODO <br>
 * 创建日期： 2021/7/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int left = 0 , right = nums.length - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            if ((leftNum & 1) != 0) {
                left++;
                continue;
            }
            if ((rightNum & 1) != 1) {
                right--;
                continue;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    private void swap(int[] nums,int i , int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
