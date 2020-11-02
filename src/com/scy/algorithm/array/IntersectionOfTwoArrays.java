package com.scy.algorithm.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 类名： IntersectionOfTwoArrays <br>
 * 描述：给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 来源：力扣（LeetCode）349
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 创建日期： 2019/12/2 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        TreeSet<Integer> set2 = new TreeSet<>();
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);
        int[] nums = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            nums[index++] = num;
        }
        return nums;
    }

    //双指针法
    public int[] intersection2(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int[] target = new int[length1 + length2];
        int index0 = 0, index1 = 0, index2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (index1 < nums1.length && index2 < nums2.length) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                if (index0 == 0 || num1 != target[index0 - 1]) {
                    target[index0++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 > num2) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOfRange(target, 0, index0);
    }
}
