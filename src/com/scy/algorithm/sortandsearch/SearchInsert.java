package com.scy.algorithm.sortandsearch;

/**
 * 类名： SearchInsert <br>
 * 描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）35. 搜索插入位置
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/9/3 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1, ans = nums.length;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
