package com.scy.algorithm;

/**
 * @desc:
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-07-07 23:19
 **/
public class Test_Byte_Dance {


    //输入: logs = [[1, 0, 5], [2, 0, 6], [3, 0, 3], [4, 1, 2], [5, 1, 3], [6, 2, 3], [7, 3, 4], [8, 4, 6]]
    //输出: [3, 5, 5, 3, 3, 2, 0]
    private int[] logUser(int[][] data) {
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            max = Math.max(max,data[i][2] - data[i][1]);
        }
        int[] res = new int[max + 1];
        for (int i = 0; i < data.length; i++) {
            for (int j = data[i][1]; j < data[i][2]; j++) {
                res[j]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
