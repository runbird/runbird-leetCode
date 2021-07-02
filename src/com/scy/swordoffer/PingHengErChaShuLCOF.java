package com.scy.swordoffer;

import com.scy.algorithm.datastructure.tree.TreeNode;

/**
 * 类名： PingHengErChaShuLCOF <br>
 * 描述：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）剑指 Offer 55 - II. 平衡二叉树
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/1 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PingHengErChaShuLCOF {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHigh(TreeNode root) {
        if (root == null) return 0;
     //   return Math.max(getHigh(root.left),getHigh(root.right)) + 1;
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.max(left,right) + 1;
    }
}