package com.scy.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）283
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-01-12 10:19
 **/
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k++;
            } else {
                map.put(j++, nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - k) {
                nums[i] = map.get(i);
            } else {
                nums[i] = 0;
            }
        }
    }

    public void bufferMoveZero(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num !=0)
                nums[index++] = num;
        }
        while (nums.length - index > 0) {
            nums[index++]  = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}
