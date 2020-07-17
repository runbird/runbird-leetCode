package com.scy.algorithm.array;

/**
 * 类名： SearchInsertPosition <br>
 * 描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）35
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/17 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mind = (left + right) / 2;
            if (target == nums[mind]) return mind;
            if (target > nums[mind]) {
                left = mind + 1;
            } else if (target < nums[mind]){
                right = mind - 1;
            }
        }
        //此时 right = left
        return target <= nums[left] ? left : left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(nums, target));
    }
}
