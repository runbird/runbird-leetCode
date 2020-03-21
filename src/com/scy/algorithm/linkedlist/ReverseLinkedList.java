package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

/**
 * @desc: 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）206
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Suocaiyuan
 * @date: 2019-12-02 22:31
 **/
public class ReverseLinkedList {

    /**
     * 双指针法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            //临时节点
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    /**
     * 递归法
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList2(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


        public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        ReverseLinkedList reverse = new ReverseLinkedList();
        ListNode result = reverse.reverseList(listNode);
        System.out.println(result.toString());
    }
}
