package com.scy.algorithm.tree;

/**
 * 类名： SumOfLeftLeaves <br>
 * 描述：计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）404
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/9/30 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
