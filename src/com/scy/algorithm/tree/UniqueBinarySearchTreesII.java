package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： UniqueBinarySearchTreesII <br>
 * 描述：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 * 提示：
 * 0 <= n <= 8
 *
 * 来源：力扣（LeetCode）95
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/21 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class UniqueBinarySearchTreesII {

    //递归法
    public List<TreeNode> generateTrees(int n) {
        if (n < 1){
            return new ArrayList<>();
        }
        return reverse(1,n);
    }

    private List<TreeNode> reverse(int start ,int end) {
        List<TreeNode> tree = new ArrayList<>();
        if (start > end) {
            tree.add(null);
            return tree;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = reverse(start, i-1);
            List<TreeNode> rightTree = reverse(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    tree.add(cur);
                }
            }
        }
        return tree;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
