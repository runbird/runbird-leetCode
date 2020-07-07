package com.scy.algorithm.tree;

import com.scy.algorithm.datastructure.tree.TreeNode;

/**
 * 类名： PathSum <br>
 * 描述：给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）112
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PathSum {

    //方法一  树递归的套路模板
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val - sum == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //方法二

    public boolean hasPathSum2(TreeNode root, int sum) {
        return this.helper(root, 0, sum);
    }

    private boolean helper(TreeNode node,int cur, int sum) {
        if (node == null) return false;
        cur += node.val;
        if (node.left == null && node.right == null) {
            return cur == sum;
        }else {
            return helper(node.left, cur, sum) || helper(node.right, cur, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)
                        ), null),
                new TreeNode(8,
                        new TreeNode(13, null, null),
                        new TreeNode(4,
                                null,
                                new TreeNode(1, null, null))));
        PathSum ps = new PathSum();
        System.out.println(ps.hasPathSum2(root, 22));
    }
}
