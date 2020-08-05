package com.scy.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： HouseRobberIII <br>
 * 描述：在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）337
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/5 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class HouseRobberIII {

    //解法一 递归
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }

    //解法二、记忆化 - 解决重复子问题
    public int rob2(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return reversePro(root, memo);
    }

    private int reversePro(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        int money = root.val;
        if (root.left != null) {
            money += reversePro(root.left.left, memo) + reversePro(root.left.right, memo);
        }
        if (root.right != null) {
            money += reversePro(root.right.left, memo) + reversePro(root.right.right, memo);
        }
        int result = Math.max(money, reversePro(root.left, memo) + reversePro(root.right, memo));
        memo.put(root, result);
        return result;
    }


    //当前节点选择不偷[0]：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
    //当前节点选择偷[1]：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
    //作者：reals
    //链接：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
    //来源：力扣（LeetCode)
    public int rob3(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
