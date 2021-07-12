package com.scy.algorithm.tree;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名： LowestCommonAncestorOfABinarySearchTree <br>
 * 描述：235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 <br>
 * 创建日期： 2020/9/27 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode result = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                result = pathP.get(i);
            } else {
                //取最近的
                break;
            }
        }
        return result;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            result.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        result.add(node);
        return result;
    }

    //递归写法参考LowestCommonAncestorOfABinaryTree

    public static void main(String[] args) {
        int x = 4;
        System.out.println("Value" + ((x>4)?88.8:8));
    }
}
