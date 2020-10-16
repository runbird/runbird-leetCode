package com.scy.algorithm.array;

import java.util.Arrays;

/**
 * 类名： SquaresOfASortedArray <br>
 * 描述：给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）977
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/16 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SquaresOfASortedArray {

    //暴力法
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    //双指针法
    public int[] sortedSquares2(int[] A) {
        int length = A.length;
        int[] ans = new int[length];
        for (int i = 0, j = length - 1, pos = length - 1; i <= j;) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[pos] = A[j] * A[j];
                j--;
            } else {
                ans[pos] = A[i] * A[i];
                i++;
            }
            pos--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SquaresOfASortedArray sos = new SquaresOfASortedArray();
        System.out.println(sos.sortedSquares2(nums));
    }

}
