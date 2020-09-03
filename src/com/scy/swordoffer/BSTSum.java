package com.scy.swordoffer;

import com.scy.algorithm.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： BSTSum <br>
 * 描述：剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 提示：
 * 节点总数 <= 10000 <br>
 * 创建日期： 2020/9/3 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BSTSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list) {
        if (root == null) return;

        List<Integer> subList = new ArrayList<>(list);
        subList.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            subList.add(root.val);
            ans.add(subList);
        }

        dfs(root.left, sum - root.val, ans, list);
        dfs(root.right, sum - root.val, ans, list);
    }
}