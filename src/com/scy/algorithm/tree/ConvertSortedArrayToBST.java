package com.scy.algorithm.tree;

import com.scy.algorithm.datastructure.tree.TreeNode;

import java.util.Random;

/**
 * @desc:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）108
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-06-20 10:38
 **/
public class ConvertSortedArrayToBST {

    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    //方法一 中序遍历：始终选择中间位置左边元素作为根节点
    private TreeNode helper(int left ,int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        //选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 1，可以使得树保持平衡
        //而偶数个数中，始终选择左节点或右节点作为根节点，结果是不一样的
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid-1);
        root.right = helper(mid +1 , right);
        return root;
    }

    //方法二：中序遍历：始终选择中间位置右边元素作为根节点
    private TreeNode helper2(int left ,int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        if ((left + right) %2 == 0) mid ++;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid-1);
        root.right = helper(mid +1 , right);
        return root;
    }

    //方法三：中序遍历：选择任意一个中间位置元素作为根节点
    Random random = new Random();
    private TreeNode helper3(int left ,int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        // 如果 left + right 是偶数，随机选择 p + 0 或者 p + 1
        if ((left + right) % 2 == 1) {
            mid += random.nextInt(2);
        }
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper3(left, mid - 1);
        root.right = helper3(mid +1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ConvertSortedArrayToBST csa = new ConvertSortedArrayToBST();
        csa.sortedArrayToBST(nums);
    }
}
