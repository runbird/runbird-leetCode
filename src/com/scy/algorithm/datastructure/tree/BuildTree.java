package com.scy.algorithm.datastructure.tree;

/**
 * 类名： BuildTree <br>
 * 描述：构建树结构 <br>
 * 创建日期： 2019/11/8 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BuildTree {

    public static BST<Integer> build(int[] nums) {
        BST<Integer> bst = new BST<>();
        for (int num : nums) {
            bst.add(num);
        }
        return bst;
    }
}
