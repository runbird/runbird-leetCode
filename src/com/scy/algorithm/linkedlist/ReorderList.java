package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： ReorderList <br>
 * 描述：给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）143
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 双指针法
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slowp = head;
        ListNode fastp = head;

        // 当快指针到达链表末尾，慢指针恰好到达链表中点之前的节点
        while (fastp.next != null && fastp.next.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }

        // 拟造一个 “新链表头”，将原链表分为两个“等长”链表
        ListNode newHead = slowp.next;
        slowp.next = null;

        newHead = reverseList(newHead);

        // 将两半链表，交相穿插拼接
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    /**
     * 倒置 链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 2, 3, 4, 5});
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList2(node);
    }
}
