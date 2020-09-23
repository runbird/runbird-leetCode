package com.scy.algorithm.tree;

/**
 * 类名： ConvertBSTtoGreaterTree <br>
 * 描述：给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）538
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/9/21 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2, null, null), new TreeNode(13, null, null));
        ConvertBSTtoGreaterTree cbgt = new ConvertBSTtoGreaterTree();
        System.out.println(cbgt.convertBST(root));
    }
}
