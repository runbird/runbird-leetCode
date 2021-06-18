package com.scy.algorithm.dpdfs.dynamicprogramming;

/**
 * 类名： PredictTheWinner <br>
 * 描述：给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 示例 1：
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 *
 * 示例 2：
 * 输入：[1, 5, 233, 7]
 * 输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 *      最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 *  
 * 提示：
 *
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于 10000000 。
 * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
 *
 * 来源：力扣（LeetCode）486
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/9/1 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PredictTheWinner {

    //递归法 https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        return recurs(nums, 0, nums.length - 1, 1) > 0;
    }

    private int recurs(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + recurs(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + recurs(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }

    //dp
    public boolean PredictTheWinner2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        System.arraycopy(nums, 0, dp, 0, length);
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 4, 6};
        PredictTheWinner ptw = new PredictTheWinner();
        ptw.PredictTheWinner2(nums);
    }
}
