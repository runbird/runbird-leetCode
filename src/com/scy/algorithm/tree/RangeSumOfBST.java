package com.scy.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名： RangeSumOfBST <br>
 * 描述：给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * 来源：力扣（LeetCode）938
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/4/27 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        //BST右子树都大于root,如果root > high 则只用计算左子树
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (cur == null){
                continue;
            }
            if (cur.val > high){
                q.offer(cur.left);
            }else if (cur.val < low){
                q.offer(cur.right);
            }else {
                sum += cur.val;
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sum;
    }
}
