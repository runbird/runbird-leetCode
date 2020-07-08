package com.scy.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： SubarraySumEqualsKSubmissions <br>
 * 描述：给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）560
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/8 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SubarraySumEqualsKSubmissions {

    //方法一 前缀和求解
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i] += sum;
            sum += nums[i];
        }
        pre[n] = sum;

        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (pre[j] - pre[i] == k) count ++;
            }
        }
        return count;
    }

    //    链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
    public int subarraySumPro(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    //方法二 前缀和求解 哈希表优化
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> dict = new HashMap<>();
        //前缀和为0的base，有1个
        dict.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            // 查找有多少个 sum[i] 等于 sum[j] - k
            if (dict.containsKey(sum - k)) {
                count += dict.get(sum - k);
            }
            // 更新 sum[j] 的个数
            dict.put(sum, dict.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1} ;
        int n = 2;
        SubarraySumEqualsKSubmissions ssek = new SubarraySumEqualsKSubmissions();
        System.out.println(ssek.subarraySum2(nums, n));
    }
}
