package com.scy.algorithm.sortandsearch;

/**
 * 类名： BasicMergeSort <br>
 * 描述：归并排序 <br>
 * 创建日期： 2021/6/21 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BasicMergeSort {
    public void mergeSort(int[] nums) {
        int[] j = new int[nums.length];
        if (nums == null || nums.length < 1) {
            return;
        }
        merge(nums, 0, nums.length, j);
    }

    private void merge(int[] nums, int i, int j, int[] temp) {
        // 空区间 或 只有一个元素
        // 为了防止i + 1溢出，这里用i >= j先判断一下
        if (i >= j || i + 1 >= j) {
            return;
        }
        //分成两半获取
        final int m = i + ((j - i) >> 1);
        //计算左半部分
        merge(nums,i,m,temp);
        //计算右半部分
        merge(nums,m,j,temp);

        // start指向左子数组的开头，end指向右子数组的开头
        // to指向要临时数组t与区间[i, j)对应的位置
        int start = i;
        int end = m;
        int to = i;

        while (start < m || end < j) {
            // 如果右子数组没有元素 或 左子数组开头的元素小于右子数组开头的元素
            // 那么取走左子数组开头的元素
            // 考点：nums[start] <= nums[end]这样可以保证合并排序是稳定的，不要写错!
            if (end >= j || start < m && nums[start] <= nums[end]) {
                temp[to++] = nums[start++];
            } else {
                temp[to++] = nums[end++];
            }
        }

        // 把合并的结果拷回原来的数组nums[]
        for (start = i; start < j; start++) {
            nums[start] = temp[start];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 6, 3, 1, 2, 1, 8, 7};
        new BasicMergeSort().mergeSort(nums);
    }
}
