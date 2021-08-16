package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 类名： MorrisSearchTree <br>
 * 描述：Morris 遍历树 <br>
 * 创建日期： 2021/8/13 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MorrisSearchTree {

    /**
     * Morris遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        var res = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            res.add(cur.val);
            root = cur.right;
        }
        return res;
    }
}
