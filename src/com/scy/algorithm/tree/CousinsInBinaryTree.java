package com.scy.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名： CousinsInBinaryTree <br>
 * 描述：在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）993. 二叉树的堂兄弟节点
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/14 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CousinsInBinaryTree {

    //BFS
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();
        node.offer(root);
        val.offer(root.val);
        while (!node.isEmpty()) {
            int size = node.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = node.poll();
                val.poll();
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y ||
                            cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    node.offer(cur.left);
                    val.offer(cur.left.val);
                }
                if (cur.right != null) {
                    node.offer(cur.right);
                    val.offer(cur.right.val);
                }
            }

            if (val.contains(x) && val.contains(y)) {
                return true;
            }
        }
        return false;
    }

    //DFS
    private TreeNode xParent = null;//x的父节点
    private TreeNode yParent = null;//y的父节点
    private int xDepth = -1;//x的深度
    private int yDepth = -2;//y的深度

    public boolean isCousins2(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        //如果他俩的深度一样，也就是在同一层，又不是同一个父亲，那么他俩
        //就是堂兄弟节点，否则不是
        return xDepth == yDepth && xParent != yParent;
    }

    public void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null)
            return;
        if (root.val == x) {
            //如果找到了x节点，就把他的父节点和深度记录下来
            xParent = parent;
            xDepth = depth;
        } else if (root.val == y) {
            //如果找到了y节点，就把他的父节点和深度记录下来
            yParent = parent;
            yDepth = depth;
        }
        //如果确定他俩是堂兄弟节点了，直接返回，不用再往下遍历了
        if (xDepth == yDepth && xParent != yParent)
            return;
        dfs(root.left, root, x, y, depth + 1);
        dfs(root.right, root, x, y, depth + 1);
    }
}
