package com.scy.swordoffer;

import com.scy.algorithm.datastructure.array.ListNode;

/**
 * 类名： ReverseListLCOF <br>
 * 描述：剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ <br>
 * 创建日期： 2020/8/10 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReverseListLCOF {

    //图示
    //https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        //将中间的节点挨个反转
        head.next.next = head;
        head.next = null;
        //最终的头节点，就是原ListNode的最终节点
        return cur;
    }

    //双指针法
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
