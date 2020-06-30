package com.scy.swordoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 类名： TwoStack <br>
 * 描述：剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用 <br>
 * 创建日期： 2020/6/30 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CQueue {
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    //private LinkedList<Integer> listA,listB;
    private Deque<Integer> listA, listB;

    public CQueue() {
        this.listA = new LinkedList<>();
        this.listB = new LinkedList<>();
    }

    public void appendTail(int value) {
        this.listA.push(value);
    }

    public int deleteHead() {
        if (!listB.isEmpty()) return listB.pop();
        if (listA.isEmpty()) return -1;
        while (!listA.isEmpty())
            listB.push(listA.pop());
        return listB.pop();
    }

    public static void main(String[] args) {

    }
}

