package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 类名： IntersectionOfTwoLinkedLists <br>
 * 描述：给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 * 来源：力扣（LeetCode）160
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/6/4 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //A遍历到A链表结束后，从B链表头开始；B遍历相反
    //时间复杂度 O(a + b)： 最差情况下（即 |a - b| = 1 , c = 0 ），此时需遍历 a + b个节点。
    //空间复杂度 O(1)： 节点指针 A , B 使用常数大小的额外空间。
    //
    //作者：jyd
    //链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/intersection-of-two-linked-lists-shuang-zhi-zhen-l/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA , pb = headB;
        while (pa != pb){
            pa = pa == null ? pb : pa.next;
            pb = pb == null ? pa : pb.next;
        }
        return pa;
    }
    //差值法
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int a = 0, b = 0;
        ListNode pa = headA, pb = headB;
        while (pa != null && ++a > 0) pa = pa.next;
        while (pb != null && ++b > 0) pb = pb.next;
        int abs = Math.abs(a - b);
        while (abs-- > 0) {
            if (a > b) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        while (headA != null || headB != null) {
            if (headA.equals(headB)) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
