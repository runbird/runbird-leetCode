package com.scy.algorithm.array;

/**
 * 类名： SearchInRotatedSortedArrayII <br>
 * 描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）81
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/3/18 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SearchInRotatedSortedArrayII {
    /**
     * 第一类
     * 10111和 11101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
     * 第二类
     * 2 3 4 5 6 7 1 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
     * 这种情况下，前半部分有序。因此如果 nums[start] <=target < nums[mid]，则在前半部分找，否则去后半部分找。
     * 第三类
     * 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
     * 这种情况下，后半部分有序。因此如果 nums[mid] < target <=nums[end]。则在后半部分找，否则去前半部分找。
     *
     * 作者：reedfan
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
     * 来源：力扣（LeetCode）
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0 , end = nums.length - 1;
        int mind ;
        while (start <= end) {
            mind = start + (end - start) / 2;
            if (nums[mind] == target) return true;
            if (nums[mind] == nums[start]) start++;
            //前半部分有序
            if (nums[mind] > nums[start]) {
               //target在前半部分
                if (target < nums[mind] && nums[start] <= target) {
                    end = mind - 1;
                } else {
                    start = mind + 1;
                }
            } else {
                if (target > nums[mind] && nums[end] >= target) {
                    start = mind + 1;
                } else {
                    end = mind - 1;
                }
            }
        }
        return false;
    }
}
