package com.scy.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）219
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 滑动窗口解决
     * 思路
     * 将每个元素与它之前的 k 个元素中比较查看它们是否相等。
     *
     * 算法
     *
     * 这个算法维护了一个 k 大小的滑动窗口，然后在这个窗口里面搜索是否存在跟当前元素相等的元素。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 ) return false;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,9};
        ContainsDuplicateII test = new ContainsDuplicateII();
        boolean b = test.containsNearbyDuplicate2(nums, 3);
        System.out.println(b);
    }
}
