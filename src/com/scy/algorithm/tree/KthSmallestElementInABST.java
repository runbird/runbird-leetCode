package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类名： KthSmallestElementInABST <br>
 * 描述： 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *  
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 来源：力扣（LeetCode）230
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。021/5/31 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = deep(root, new ArrayList<>());
        return result.get(k - 1);
    }

    private ArrayList<Integer> deep(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;
        deep(node.left,list);
        list.add(node.val);
        deep(node.right,list);
        return list;
    }

    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
