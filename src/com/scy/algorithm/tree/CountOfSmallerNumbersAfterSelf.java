package com.scy.algorithm.tree;

import java.util.Arrays;
import java.util.List;

/**
 * 类名： CountOfSmallerNumbersAfterSelf <br>
 * 描述：给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * 来源：力扣（LeetCode）315
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/12 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CountOfSmallerNumbersAfterSelf {

    //BST
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        Arrays.fill(result, 0);
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = createNode(root, new Node(nums[i]), result, i);
        }
        return Arrays.asList(result);
    }

    private Node createNode(Node root, Node node, Integer[] res, int i) {
        if (root == null) {
            root = node;
            return root;
        }
        if (root.val >= node.val) {
            root.count++;
            root.left = createNode(root.left, node, res, i);
        } else {
            res[i] += root.count + 1;
            root.right = createNode(root.right, node, res, i);
        }
        return root;
    }



    public static void main(String[] args) {
        //int[] nums = {5,2,6,1};
        int[] nums = {2,0,1};
        CountOfSmallerNumbersAfterSelf casns = new CountOfSmallerNumbersAfterSelf();
        System.out.println(casns.countSmaller(nums));
    }
}

class Node {
    int val;
    int count;
    Node left;
    Node right;

    public Node(int value) {
        this.val = value;
    }
}