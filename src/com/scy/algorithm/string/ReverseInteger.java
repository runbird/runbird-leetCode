package com.scy.algorithm.string;

/**
 * @desc: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 来源：力扣（LeetCode）7
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-01-12 20:42
 **/
public class ReverseInteger {
    public int reverse(int x) {
        /**
         ret 保存旧的翻转中间值, temp 保存新的翻转过程中间值
         依次提取 x 的末位加入 temp, 如果发生溢出则通过temp/10
         无法得到上一轮的翻转结果 ret
         **/
        int ret = 0;
        while (x != 0) {
            int temp = ret * 10 + x % 10;
            if (temp / 10 != ret)
                return 0;
            ret = temp;
            x /= 10;
        }
        return ret;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {

    }
}
