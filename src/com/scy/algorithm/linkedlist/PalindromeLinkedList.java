package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）234
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-06-06 22:41
 **/
public class PalindromeLinkedList {

    //方法一 赋值法
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) return false;
            start ++;
            end --;
        }
        return true;
    }

    //方法二 递归

    //方法三双指针

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 1};
        ListNode node = new ListNode(nums);
        PalindromeLinkedList pl = new PalindromeLinkedList();
        boolean palindrome = pl.isPalindrome(node);
        System.out.println(palindrome);
    }


}
