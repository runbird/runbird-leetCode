package com.scy.algorithm.array;

import java.util.Arrays;

/**
 * 类名： MergeSortedArray <br>
 * 描述：
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）88
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/22 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MergeSortedArray {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //极其优秀的算法
    //作者：guanpengchn
    //链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/hua-jie-suan-fa-88-he-bing-liang-ge-you-xu-shu-zu-/
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 > 0 && len2 > 0) {
            nums1[len--] = nums2[len2] >= nums1[len1] ? nums2[len2--] : nums1[len1--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    public static void main(String[] args) {
        int[] sum1 = {1, 2, 3, 0, 0, 0}, sum2 = {2, 5, 6};
        int m = 3, n = 3;
        MergeSortedArray msa = new MergeSortedArray();
        msa.merge2(sum1, m, sum2, n);
    }
}
