package com.scy.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： SingleNumber <br>
 * 描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）136
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/1/10 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SingleNumber {

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            count = count == null ? 1 : ++count;
            map.put(nums[i], count);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                // a^b a、b不同时为0或者1时，返回1，否则0
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumber2(nums);
    }
}
