package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

/**
 * 描述: 拆分链表
 * 给定一个链表，需要把链表从中间拆分成长度相等的两半（如果链表长度为奇数，那么拆分之后，前半部分长度更长一点）。
 * 输入：[1->2->3->4->5]
 * 输出：[1->2->3, 4->5]
 * <p>
 * 创建日期： 2021/7/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SplitLinkedList {
    public ListNode[] split(ListNode head) {
        if (head == null) return new ListNode[]{};
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return new ListNode[]{mid, next};
    }

    private ListNode findMid(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = head;
        ListNode back = head;
        ListNode pre = dummy;
        while (front != null && front.next != null) {
            front = head.next.next;
            pre = back;
            back = head.next;
        }
        //front 为null时，pre节点为中间节点
        // dummy-> 1 -> 2 -> 3 -> 4   null
        //             pre   b        front
        return front == null ? pre : back;
    }

}
