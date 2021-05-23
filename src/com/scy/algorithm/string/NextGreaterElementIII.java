package com.scy.algorithm.string;

import java.util.Arrays;

/**
 * @desc: 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：21
 *
 * 示例 2：
 * 输入：n = 21
 * 输出：-1
 *
 * 来源：力扣（LeetCode）556
 * 链接：https://leetcode-cn.com/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-05-23 18:25
 **/
public class NextGreaterElementIII {

    //12341 -> 12413
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        char[] c = num.toCharArray();
        int len = c.length;
        int index = -1;
        for (int i = len - 1; i >= 0 && index == -1; i--) {
            int j = i - 1;
            if (j >= 0 && c[j] < c[i]) {
                //从[i, len - 1]区间中找到刚好大于num[i - 1]的数
                //因为[i, len - 1]中元素是单调递减的, 所以从后往前遍历
                for (int k = len - 1; k >= i; k--) {
                    if (c[k] > c[j]) {
                        char temp = c[j];
                        c[j] = c[k];
                        c[k] = temp;
                        index = i;
                        break;
                    }
                }
            }
        }

        if (index == -1)
            return -1;

        //将index 之后的元素从小到大排序
        Arrays.sort(c, index, len);

        long res = 0;
        for (int i = 0; i < len; i++) {
            res = res * 10 + (c[i] - '0');
        }

        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}
