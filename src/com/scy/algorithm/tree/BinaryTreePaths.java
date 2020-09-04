package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： BinaryTreePaths <br>
 * 描述：给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）257
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/9/4 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String str = "";
        dfs(root, list ,str);
        return list;
    }

    private void dfs(TreeNode root, List<String> list,String str) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            str += root.val;
            list.add(str);
            return;
        }
        str += root.val + "->";
        dfs(root.left,list,str);
        dfs(root.right,list,str);
    }

    public static void main(String[] args) {

    }
}
