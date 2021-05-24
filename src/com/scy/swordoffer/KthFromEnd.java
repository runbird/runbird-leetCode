package com.scy.swordoffer;

import com.scy.algorithm.datastructure.array.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： KthFromEnd <br>
 * 描述：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）剑指 Offer 22. 链表中倒数第k个节点
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/5/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class KthFromEnd {

    /*
        快慢指针
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /**
     * by myself
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null) return null;
        Map<Integer, ListNode> dict = new HashMap<>();
        int i = 0;
        ListNode cur = head;
        while (cur != null) {
            dict.put(++i, cur);
            cur = cur.next;
        }
        return dict.get(dict.size() - k + 1);
    }
}
