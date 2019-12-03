package com.scy.algorithm;

/**
 * @desc:
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,-1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）220
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Suocaiyuan
 * @date: 2019-12-02 20:38
 **/
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //TODO
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j < i; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t)  return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII duplicateIII = new ContainsDuplicateIII();
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        boolean b = duplicateIII.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }
}
