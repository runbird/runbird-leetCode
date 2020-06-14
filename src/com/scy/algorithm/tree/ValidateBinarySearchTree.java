package com.scy.algorithm.tree;

import com.scy.algorithm.datastructure.tree.TreeNode;

import java.util.*;

/**
 * 类名： ValidateBinarySearchTree <br>
 * 描述：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *   2
 *  / \
 * 1   3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 *   5
 *  / \
 * 1   4
 *    / \
 *   3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）98
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/13 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ValidateBinarySearchTree {

    //方法一 迭代
    public boolean isValidBST(TreeNode root) {
        return recurse(root, null, null);
    }

    public boolean recurse(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!recurse(root.left, lower, val)) return false;
        if (!recurse(root.right, val, upper)) return false;
        return true;
    }


    //方法二 广度优先遍历
    private Queue<TreeNode> queue = new LinkedList<>();
    private Queue<Integer> lowers = new LinkedList<>();
    private Queue<Integer> uppers = new LinkedList<>();

    public boolean isValidBST2(TreeNode root) {
        Integer upper = null, lower = null, val;
        update(root, upper, lower);
        while (!queue.isEmpty()) {
            root = queue.poll();
            upper = uppers.poll();
            lower = lowers.poll();

            if (root == null) continue;
            val = root.val;
            if (upper != null && val >= upper) return false;
            if (lower != null && val <= lower) return false;
            update(root.left, val, lower);
            update(root.right, upper, val);
        }
        return true;
    }

    public void update(TreeNode root, Integer upper, Integer lower) {
        queue.add(root);
        uppers.add(upper);
        lowers.add(lower);
    }


    //方法三 中序遍历
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer inOrder = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (inOrder!= null && root.val <= inOrder) return false;
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }

    //中序遍历 plus
    long pre = Long.MIN_VALUE;

    public boolean isValidBST4(TreeNode root) {
        if (root == null) return true;
        //访问左子树
        if (!isValidBST4(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        //访问右子树
        return isValidBST4(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10,
                new TreeNode(5, null, new TreeNode(6, null, null)),
                new TreeNode(15, null, new TreeNode(20, null, null)));
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        System.out.println(vbst.isValidBST3(node));
    }

}
