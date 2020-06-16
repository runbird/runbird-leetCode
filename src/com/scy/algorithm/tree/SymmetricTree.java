package com.scy.algorithm.tree;

import com.scy.algorithm.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名： SymmetricTree <br>
 * 描述：给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）101
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/15 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SymmetricTree {

    //方法一 迭代遍历
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> p = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        p.add(root);
        q.add(root);
        //先层序遍历
        while (!p.isEmpty() && !q.isEmpty()) {
            int pSize = p.size();
            int qSize = q.size();
            TreeNode pNode = p.poll();
            TreeNode qNode = q.poll();
            if (pNode == null && qNode == null) continue;
            if (pNode == null || qNode == null) return false;
            if (pNode.val != qNode.val) return false;
            if (pNode.left != null && qNode.right != null) {
                p.add(pNode.left);
                q.add(qNode.right);
            }
            if (pNode.right != null && qNode.left != null) {
                p.add(pNode.right);
                q.add(qNode.left);
            }
        }
        return true;
    }


    //方法一 迭代遍历
    public boolean isSymmetricPro(TreeNode root) {
        return isSymmetricProCheck(root, root);
    }

    private boolean isSymmetricProCheck(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        //先层序遍历
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) continue;
//            if (p == null || q == null) return false;
//            if (p.val != q.val) return false;
            if ((p == null || q == null) || (p.val != q.val)) return false;
            if (p.left != null && p.right != null) {
                queue.add(p.left);
                queue.add(q.right);
            }
            if (p.right != null && q.left != null) {
                queue.add(p.right);
                queue.add(q.left);
            }
        }
        return true;
    }

    //方法二 镜像对比
    public boolean isSymmetric2(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        java.lang.String s = "";
//        ClassLoader classLoader = s.getClass().getClassLoader();
//        System.out.println(classLoader);
        SymmetricTree symmetricTree = new SymmetricTree();
        ClassLoader classLoader = symmetricTree.getClass().getClassLoader();
        System.out.println(classLoader);
    }
}
