package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： JumpGameII <br>
 * 描述：给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）45. 跳跃游戏 II
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/9/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class JumpGameII {


    public int jump(int[] nums) {
        int ans = 0, start = 0, end = 1;
        while (end < nums.length) {
            int max = 0;
            for (int i = start; i < end; i++) {
                //能跳到的最远距离
                max = Math.max(max, i + nums[i]);
            }
            //下一次的起跳位置
            start = end;
            //下一次起跳的结束位置
            end = max + 1;
            //跳跃次数
            ans++;
        }
        return ans;
    }

    public int jump2(int[] nums) {
        int ans = 0, end = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            //i == end单次跳的最远距离
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
