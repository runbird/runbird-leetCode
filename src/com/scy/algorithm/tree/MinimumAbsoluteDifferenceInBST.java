package com.scy.algorithm.tree;

/**
 * 类名： MinimumAbsoluteDifferenceInBST <br>
 * 描述：给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出： 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * 提示：
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 来源：力扣（LeetCode）530
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/12 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MinimumAbsoluteDifferenceInBST {

    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root) {

        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2, null, null), null));
        MinimumAbsoluteDifferenceInBST min = new MinimumAbsoluteDifferenceInBST();
        System.out.println(min.getMinimumDifference(root));
    }
}
