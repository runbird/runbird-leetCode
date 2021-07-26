package com.scy.swordoffer;

/**
 * 类名： MyPow <br>
 * 描述：实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）剑指 Offer 16. 数值的整数次方
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/23 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long N = n;
        double res = 1.0;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        while (N > 0) {
            if ((N & 1) == 1) res *= x;
            x *= x;
            N >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        MyPow pow = new MyPow();
        pow.myPow(2.0, 2);
    }
}
