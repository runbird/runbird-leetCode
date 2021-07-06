package com.scy.swordoffer;

import com.scy.algorithm.datastructure.tree.TreeNode;

/**
 * 类名： IsSubStructure <br>
 * 描述：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *
 * 给定的树 B：
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）剑指 Offer 26. 树的子结构
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/5 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true ；
     当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
     当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
     */
    public boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}
