package com.scy;

/**
 * 类名： RemoveLinkedListElements <br>
 * 描述：LeetCode 203  <br>
 *     输入: 1->2->6->3->4->5->6, val = 6
 *     输出: 1->2->3->4->5
 * 创建日期： 2019/10/16 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next !=null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
