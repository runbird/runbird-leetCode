package com.scy.algorithm.array;

import java.util.stream.IntStream;

/**
 * 类名： FindPivotIndex <br>
 * 描述：给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1：
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 * 示例 2：
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *  
 * 说明：
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 *
 * 来源：力扣（LeetCode）724
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FindPivotIndex {

/**  .....X...
     AXB(X左侧为和A，右侧为和B,整个数组和为S) 若有中心索引 A = B = S-A-X
     S = 2 * A + X
 */
    public int pivotIndex(int[] nums) {
        //IntStream 数据量小的话 效率低一些
        int sum = IntStream.of(nums).sum();
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (2 * pre + v == sum) return i;
            pre += v;
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 7, 3, 6, 5, 6};
        int[] arr = {1, 1};
        FindPivotIndex fpi = new FindPivotIndex();
        System.out.println(fpi.pivotIndex(arr));
    }
}
