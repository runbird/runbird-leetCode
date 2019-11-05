package com.scy.algorithm;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Arrays;
import java.util.List;

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

    //使用虚拟头节点 不使用递归
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

    //不使用虚拟头节点 使用递归
    public ListNode removeElements2(ListNode node, int val) {
        if (node == null) return null;

        ListNode result = removeElements2(node.next, val);
        return result.val == val? result:result.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1);
        List<Integer> integers = Arrays.asList(1, 2, 6, 3, 4, 5, 6);
        for (int i = 0; i < integers.size(); i++) {
            listNode.setNext(new ListNode(integers.indexOf(i)));
        }
        System.out.println(listNode.toString());
    }


}
