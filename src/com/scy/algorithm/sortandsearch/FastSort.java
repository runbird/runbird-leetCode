package com.scy.algorithm.sortandsearch;

/**
 * 类名： FastSort <br>
 * 描述：快速排序 <br>
 * 创建日期： 2021/7/5 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FastSort {

    public void sort(int[] nums, int start, int end) {
        if (start < end) {
            int key = nums[start];
            int i = start;
            for (int j = start + 1; j <= end; j++) {
                if (key > nums[j]) {
                    swap(nums, j, i++);
                }
            }
            nums[start] = nums[i];
            nums[i] = key;
            swap(nums, start, i - 1);
            swap(nums, i + 1, end);
        }
    }

    public void swap(int[] nums,int i, int j) {
        if (i != j){
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, -2, 0, 4, 2};
        FastSort sort = new FastSort();
        sort.sort(nums, 0, nums.length - 1);
    }

}
