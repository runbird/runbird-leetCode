package com.scy.algorithm;

import com.scy.algorithm.datastructure.tree.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）104
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        //TODO
//        if (root == null) return 0;
//        if (root.left != null) {
//            maxDepth(root.left);
//        }
//        if (root.right != null) {
//            maxDepth(root.right);
//        }
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        MaximumDepthOfBinaryTree depth = new MaximumDepthOfBinaryTree();
        int i = depth.maxDepth(node);
        System.out.println(i);
    }
}
