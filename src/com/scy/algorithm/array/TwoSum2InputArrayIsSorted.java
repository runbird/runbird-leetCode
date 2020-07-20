package com.scy.algorithm.array;

/**
 * 类名： TwoSum2InputArrayIsSorted <br>
 * 描述：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）167
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class TwoSum2InputArrayIsSorted {

    //暴力法
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        if (n < 2) return new int[2];
        int[] ans = new int[2];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return ans;
    }

    //双指针
    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target){
                return new int[]{left + 1, right + 1};
            }
            if (temp < target){
                left ++;
            }else {
                right --;
            }
        }
        return new int[2];
    }

        public static void main(String[] args) {
       // int[] numbers = new int[]{2, 7, 11, 15};
        int[] numbers = new int[]{2, 3, 4};
        int target = 6;
        TwoSum2InputArrayIsSorted tsiais = new TwoSum2InputArrayIsSorted();
        tsiais.twoSum(numbers, target);
    }
}
