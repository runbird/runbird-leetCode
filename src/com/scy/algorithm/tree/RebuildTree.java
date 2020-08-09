package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： RebuildTree
 * 描述：剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000 <br>
 * 创建日期： 2020/8/7 <br>
 *
 * 来源：力扣（LeetCode）剑指 Offer 07. 重建二叉树
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/3 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RebuildTree {

    //方法一 递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new ArrayList<>(preorder.length);
        List<Integer> inorderList = new ArrayList<>(inorder.length);
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helper(preorderList, inorderList);
    }

    private TreeNode helper(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.size() == 0) {
            return null;
        }
        //获取根节点并在中序遍历中切分 左子树 和 右子树
        Integer rootValue = preorderList.remove(0);
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderList.indexOf(rootValue);
        root.left = helper(preorderList, inorderList.subList(0, rootIndex));
        root.right = helper(preorderList, inorderList.subList(rootIndex + 1, inorderList.size()));

        return root;
    }

    //方法二 指针法
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int inEnd = preorder.length - 1;
        return helper(0, 0, inEnd, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        //创建结点
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        //找到当前节点root在中序遍历中的位置，然后再把数组分两半
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }

    //方法三
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length)
            return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        RebuildTree rb = new RebuildTree();
        System.out.println(rb.buildTree3(preorder, inorder));
    }
}
