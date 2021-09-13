package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： JumpGame <br>
 * 描述：给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ，
 * 所以永远不可能到达最后一个下标。
 * <p>
 * 来源：力扣（LeetCode）55. 跳跃游戏
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/9/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= k) {
                k = Math.max(k, i + nums[i]);
                if (k >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     1、如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
     2、可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
     3、如果可以一直跳到最后，就成功了
     **/
    /**
     * 核心思想：找出跳的最远的距离
     **/
    public boolean canJump2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, nums[i] + i);
        }
        return true;
    }
}