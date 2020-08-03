package com.scy.swordoffer;

import com.scy.algorithm.datastructure.array.ListNode;

import java.util.Stack;

/**
 * 类名： PrintLinkedListFromTailToHeadLCOF <br>
 * 描述：剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000 <br>
 * 创建日期： 2020/8/3 <br>
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author suocaiyuan
 * @version V1.0
 */
public class PrintLinkedListFromTailToHeadLCOF {

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
