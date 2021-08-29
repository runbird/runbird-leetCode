package com.scy.algorithm.array;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * 来源：力扣（LeetCode）1588. 所有奇数长度子数组的和
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0 , size = arr.length;
        for (int i = 1; i <= size; i += 2) {
            for (int j = 0; j + i <= size; j++) {
                for (int k = 0; k < i; k++) {
                    ans += arr[k + j];
                }
            }
        }
        return ans;
    }

        /**
         * 前缀和优化暴力法
         * @param arr
         * @return
         */
    public int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            sum[i] = arr[i - 1] + sum[i - 1];
        }

        int ans = 0;
        for (int len = 1; len <= n; len += 2) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                ans += sum[r + 1] - sum[l];
            }
        }
        return ans;
    }
}
