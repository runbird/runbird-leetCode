package com.scy.algorithm.math;

/**
 * 类名： PowerOfFour <br>
 * 描述：给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 *
 * 来源：力扣（LeetCode）342
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/5/31 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PowerOfFour {

    /**
     * 4的幂，一定是2的幂。先判断是不是2的幂
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
