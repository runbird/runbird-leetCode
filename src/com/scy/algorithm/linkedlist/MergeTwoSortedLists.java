package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

/**
 * @desc: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 来源：力扣（LeetCode）21
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-06-06 22:08
 **/
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        } else if (l2 == null) {
//            return l1;
//        }
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        head.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode l1 = new ListNode(nums);
        ListNode l2 = new ListNode(nums2);
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode listNode = mtsl.mergeTwoLists(l1, l2);
        System.out.println(listNode.toString());
    }
}
