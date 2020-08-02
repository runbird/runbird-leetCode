package com.scy.algorithm.tree;

import java.util.*;

/**
 * @desc:
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）114
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-08-02 13:38
 **/
public class FlattenBinaryTreeToLinkedList {
    //方法一：前序遍历
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    //方法二：前序遍历和展开同步进行
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = cur;
            }
            TreeNode left = cur.left, right = cur.right;
            if (right != null) {
                stack.add(right);
            }
            if (left != null) {
                stack.add(left);
            }
            pre = cur;
        }
    }

    //方法三：寻找前驱节点
    public void flatten3(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode next = cur.left;
            TreeNode predecessor  = next;
            while (predecessor.right != null){
                predecessor = predecessor.right;
            }
            predecessor.right = cur.right;
            cur.left = null;
            cur.right = next;
        }
        cur = cur.right;
    }


    public static void main(String[] args) {

    }
}
