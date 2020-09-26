package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）113
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-09-27 00:21
 **/
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        dfs(root.left, sum - root.val, result, list);
        dfs(root.right, sum - root.val, result, list);
        list.remove(list.size() - 1);
    }
}
