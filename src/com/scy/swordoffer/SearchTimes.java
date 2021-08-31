package com.scy.swordoffer;

/**
 * 类名： SearchTimes <br>
 * 描述：统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/8/31 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SearchTimes {
    //二分单边 + 线性扫描
    //一个朴素的想法是，找到目标值 targettarget 「首次」出现或者「最后」出现的下标，然后「往后」或者「往前」进行数量统计。
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ans = 0;
        while (r >= 0 && nums[r] == target && r-- >= 0) {
            ans++;
        }
        return ans;
    }
}
