package com.scy.algorithm.linkedlist;

import com.scy.algorithm.datastructure.array.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 类名： RemoveDuplicateNodeLcci <br>
 * 描述：编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）面试题 02.01
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RemoveDuplicateNodeLcci {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;

        Set<Integer> record = new HashSet<>();
        record.add(head.val);
        ListNode pos = head;
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (record.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};
        RemoveDuplicateNodeLcci rdn = new RemoveDuplicateNodeLcci();
        ListNode node = new ListNode(arr);
        ListNode listNode = rdn.removeDuplicateNodes(node);
        System.out.println(listNode.toString());
    }
}
