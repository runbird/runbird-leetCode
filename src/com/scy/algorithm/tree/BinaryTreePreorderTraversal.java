package com.scy.algorithm.tree;

import java.util.*;

/**
 * 类名： BinaryTreePreorderTraversal <br>
 * 描述：给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,2,3]
 *
 * 来源：力扣（LeetCode）144
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/27 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return dg(root, new ArrayList<>());
    }

    private List<Integer> dg(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return null;
        }
        ret.add(root.val);
        if (root.left != null) {
            dg(root.left,ret);
        }
        if (root.right != null) {
            dg(root.right, ret);
        }
        return ret;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        while (!queue.isEmpty() || node != null) {
            while (node != null) {
                ans.add(node.val);
                queue.add(node);
                node = node.left;
            }
            node = queue.poll();
            node = node.right;
        }
        return ans;
    }

}
