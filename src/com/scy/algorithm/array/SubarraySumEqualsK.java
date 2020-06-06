package com.scy.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）560
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-06-06 15:19
 **/
public class SubarraySumEqualsK {

    //by runbird
    public int subarraySumByRB(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int j = i;
            while (j < nums.length) {
                sum += nums[j];
                j++;
                if (sum == k) {
                    count++;
                } else if (sum > k) {
                    break;
                }
            }
        }
        return count;
    }

    //方法一：枚举
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // ++
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            //精妙之处 ！！！ 跟着最外层一直走
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    //前缀和 + 哈希表优化
    //https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
    public int subarraySumByPre(int[] nums, int k) {
        int pre = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //第一次存储值
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                count += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        SubarraySumEqualsK ssk = new SubarraySumEqualsK();
        int i = ssk.subarraySumByPre(nums, k);
        System.out.println(i);
    }
}
