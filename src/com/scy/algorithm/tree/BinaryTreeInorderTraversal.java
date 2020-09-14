package com.scy.algorithm.tree;

import java.util.*;

/**
 * 类名： BinaryTreeInorderTraversal <br>
 * 描述：94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * (leetCode) 94
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ <br>
 * 创建日期： 2020/9/14 <br>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author suocaiyuan
 * @version V1.0
 */
public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
