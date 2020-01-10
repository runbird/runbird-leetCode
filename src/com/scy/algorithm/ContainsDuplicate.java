package com.scy.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @desc: 给定一个整数数组，判断是否存在重复元素。
 * 
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 
 * 来源：力扣（LeetCode）217
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Suocaiyuan
 * @date: 2019-12-02 20:29
 **/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                return true;
            map.put(num, 1);
        }
        return false;
    }

    //时间复杂度 : O(nlog n)
    //排序的复杂度是 O(nlog n)，扫描的复杂度是 O(n)。整个算法主要由排序过程决定，因此是O(nlogn)。
    //空间复杂度 : O(1)。
    //这取决于具体的排序算法实现，通常而言，使用 堆排序 的话，是O(1)。
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    //时间复杂度 : O(n)
    //空间复杂度 : O(n) 哈希表占用的空间与元素数量是线性关系。
    public boolean containsDuplicate3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 34, 456, 768, 132, 7890, 123, 57, 77, 1};
        ContainsDuplicate duplicate = new ContainsDuplicate();
        
        long start = System.nanoTime();
        duplicate.containsDuplicate(nums);
        long time = System.nanoTime() - start;
        System.out.println(time);

        long start1 = System.nanoTime();
        duplicate.containsDuplicate2(nums);
        long time1 = System.nanoTime() - start1;
        System.out.println(time1);

        long start2 = System.nanoTime();
        duplicate.containsDuplicate3(nums);
        long time2 = System.nanoTime() - start2;
        System.out.println(time2);
    }
}
