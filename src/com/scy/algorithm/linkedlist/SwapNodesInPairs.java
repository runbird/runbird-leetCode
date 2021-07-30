package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

/**
 * 类名： SwapNodesInPairs <br>
 * 描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）24
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/13 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SwapNodesInPairs {

    /**
     * 递归方法
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }


    public ListNode swapPairs3(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode oddDummy = odd;
        ListNode even = new ListNode(-1);
        ListNode evenDummy = even;
        ListNode p = head;
        for (int i = 0; p != null; i++) {
            ListNode next = p.next;
            if ((i & 1) == 1) {
                odd.next = p;
                odd = p;
            } else {
                even.next = p;
                even = p;
            }
            p = next;
        }
        return mergeList(oddDummy.next, evenDummy.next);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        System.out.println(new SwapNodesInPairs().swapPairs2(head));
    }
}
