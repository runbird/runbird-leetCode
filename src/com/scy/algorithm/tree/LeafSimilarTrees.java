package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： LeafSimilarTrees <br>
 * 描述：请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 *
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 *
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 *
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/5/10 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class LeafSimilarTrees {

    private List<Integer> values = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        deepValues(root1);
        List<Integer> left = values.subList(0, values.size());
        values = new ArrayList<>();
        deepValues(root2);
        if (left.size() != values.size()) return false;
        for (int i = 0; i < values.size(); i++) {
            if (!values.get(i).equals(left.get(i))) return false;
        }
        return true;
    }

    public void deepValues(TreeNode root) {
        if (root == null) return ;
        if (root.left == null && root.right == null){
            values.add(root.val);
        }
        deepValues(root.left);
        deepValues(root.right);
    }
}
