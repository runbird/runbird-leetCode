package com.scy.algorithm.math;

/**
 * 类名： HammingDistance <br>
 * 描述：TODO <br>
 * 创建日期： 2021/5/27 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int s = x ^ y ,ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(a ^ 2);
        System.out.println(a ^ 1);
        System.out.println(a & 2);
        System.out.println(a & 1);
        System.out.println(a <<=1);
        System.out.println(a >>=1);
    }
}
