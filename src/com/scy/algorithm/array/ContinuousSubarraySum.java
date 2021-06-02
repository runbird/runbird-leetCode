package com.scy.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 类名： ContinuousSubarraySum <br>
 * 描述：给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 * 示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 *
 * 示例 2：
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 *
 * 示例 3：
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 * 来源：力扣（LeetCode）523
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/6/2 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ContinuousSubarraySum {

    //超时
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                int sum = 0;
                for (int l = j; l < j+i && l < nums.length; l++) {
                    sum += nums[l];
                    if (sum % k == 0 ) return true;
                }
            }
        }
        return false;
    }

    //前缀和 + 哈希
    public boolean checkSubarraySum2(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int last = 0;
        for (int i = 0; i < m; i++) {
            last = (last + nums[i]) % k;
            if (map.containsKey(last)) {
                Integer index = map.get(last);
                if (i - index >= 2) {
                    return true;
                }
            } else {
                map.put(last, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum3(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        //sum[q] - sum[p] = n * k -->  sum[q]/k -sum[p]/k = n
        //前缀和判定如果 k 相同则存在
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }

        public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
       // int[] nums = {0,0};
        ContinuousSubarraySum count = new ContinuousSubarraySum();
        System.out.println(count.checkSubarraySum3(nums, 13));
    }
}
