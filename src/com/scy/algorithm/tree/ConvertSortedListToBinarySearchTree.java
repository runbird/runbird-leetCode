package com.scy.algorithm.tree;

import com.scy.algorithm.datastructure.array.ListNode;

/**
 * 类名： ConvertSortedListToBinarySearchTree <br>
 * 描述：给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）109
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ConvertSortedListToBinarySearchTree {

    //快慢指针法
    //https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/kuai-man-zhi-zhen-jie-jue-ji-bai-liao-100de-yong-h/
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null ) return null;
        if (head.next == null) return new TreeNode(head.val);

        //快慢指针找到链表的中间结点slow，pre就是中间结点slow的前一个结点
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //链表断开为两部分，一部分是node的左子节点，一部分是node的右子节点
        pre.next = null;
        //node就是当前节点
        TreeNode node = new TreeNode(slow.val);
        //从head节点到pre节点是node左子树的节点
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{-10, -3, 0, 5, 9});
        ConvertSortedListToBinarySearchTree cslbs = new ConvertSortedListToBinarySearchTree();
        cslbs.sortedListToBST(listNode);
    }
}
