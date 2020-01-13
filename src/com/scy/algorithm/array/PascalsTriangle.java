package com.scy.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）118
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Suocaiyuan
 * @date: 2019-12-02 21:16
 **/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        //TODO
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            pascalsTriangle.add(new ArrayList<>(list));
        }
        return pascalsTriangle;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        List<List<Integer>> generate = pt.generate(5);
        System.out.println(generate.toString());
    }
}
