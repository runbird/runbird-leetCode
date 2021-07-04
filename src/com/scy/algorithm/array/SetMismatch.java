package com.scy.algorithm.array;

/**
 * @desc: 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）645. 错误的集合
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-07-04 21:52
 **/
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] dict = new int[nums.length + 1];
        for(int i : nums) dict[i]++;
        int[] ans = new int[2];
        for(int i = 1; i <= nums.length; i++){
            if(dict[i] == 0) ans[1] = i;
            if(dict[i] == 2) ans[0] = i;
        }
        return ans;
    }
}
