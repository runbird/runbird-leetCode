package com.scy.algorithm.tree;

import java.util.*;

/**
 * 类名： RecoverBinarySearchTree <br>
 * 描述：二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）99
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/8 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        //错对
        int[] twoSwapped = findTwoSwapped(nums);
        //交换
        recover(root, 2, twoSwapped[0], twoSwapped[1]);
    }


    //中序遍历
    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int size = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < size - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    //找到后
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    private int[] twoSwap(List<Integer> nums){
        int x = -1 , y = -1;
        int size = nums.size();
        for(int i = 0; i < size - 1; i++){
            if(nums.get(i+1) < nums.get(i)){
                y = nums.get(i+1);
                if(x == -1){
                    x = nums.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }


    //============================================
    public void recoverTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null , y = null , pre = null;

        while (!stack.isEmpty() || root != null) {
            //左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val > root.val) {
                y = root;
                if (x == null) {
                    x = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }

        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }


}
