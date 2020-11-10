package com.scy.algorithm.array;

/**
 * 类名： ValidMountainArray <br>
 * 描述：TODO <br>
 * 创建日期： 2020/11/3 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int index = 0;
        while (index < n - 1 && A[index + 1] > A[index]) {
            index++;
        }
        if (index == 0 || index == n - 1) {
            return false;
        }
        while (index < n - 1 && A[index + 1] < A[index]) {
            index++;
        }
        return index == n - 1;
    }

    //双指针法
    public boolean validMountainArray2(int[] A) {
        int length = A.length;
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < length && A[left] < A[left + 1]) {
            left++;
        }
        while (right - 1 > -1 && A[right] < A[right - 1]) {
            right --;
        }
        return left > 0 && right < length - 1 && left == right;
    }
}
