package com.scy.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： DegreeOfAnArray <br>
 * 描述：给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * <p>
 * 提示：
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/2/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        int du = 0; //[1, 2, 2, 3, 1] du = 2
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i])) {
                dict.put(nums[i], dict.get(nums[i]) + 1);
                du = Math.max(du, dict.get(nums[i]));
            } else {
                dict.put(nums[i], 0);
            }
        }

        int result = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dict.getOrDefault(nums[i], 0) == du) {
                for (int j = i; j < nums.length; j++) {
                    if (j == nums[i]) {
                        count++;
                    }
                    if (count == du) {
                        result = count;
                        result = Math.min(result, j - i + 1);
                    }
                }
                count = 0;
                dict.remove(nums[i]);
            }
        }
        return result;
    }
}