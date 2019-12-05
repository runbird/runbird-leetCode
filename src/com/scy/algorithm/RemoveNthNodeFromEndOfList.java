package com.scy.algorithm;

import com.scy.algorithm.datastructure.array.ListNode;

/**
 * 类名： RemoveNthNodeFromEndOfList <br>
 * 描述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）19
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2019/12/4 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RemoveNthNodeFromEndOfList {
    //单指针法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        int index = 0;
        while (pre.next != null) {
            index ++;
            pre = pre.next;
        }
        index -= n;
        pre = dummyHead;
        while (index-- > 0) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }

    //双指针法 when i changed secondListNode then dummyHead changed ？ why
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode node = new ListNode(nums);
        RemoveNthNodeFromEndOfList c = new RemoveNthNodeFromEndOfList();
        ListNode listNode = c.removeNthFromEnd2(node, 2);
        System.out.println(listNode.toString());
    }
}
