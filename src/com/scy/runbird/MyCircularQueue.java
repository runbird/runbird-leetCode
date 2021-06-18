package com.scy.runbird;

/**
 * 类名： MyCircularQueue <br>
 * 描述：环形队列 <br>
 * 创建日期： 2021/6/18 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MyCircularQueue {
    //已经使用的元素个数
    private int used = 0;
    //环形队列头
    private int front = 0;
    //环形队列尾
    private int rear = 0;
    //尾
    private int capacity = 0;
    //数据存放
    private int[] circ;

    public MyCircularQueue(int k) {
        this.capacity = k;
        circ = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        circ[rear] = value;
        rear = (rear + 1) % capacity;
        used++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        int value = circ[front];
        // 注意：这里不能使用rear - 1
        // 需要取模
        front = (front + 1) % capacity;
        used --;
        return true;
    }

    public int getFront() {
        // 如果为空，不能取出队首元素
        if (isEmpty()) {
            return -1;
        }
        // 取出队首元素
        return circ[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int tail = (rear - 1 + capacity) % capacity;
        return circ[tail];
    }

    public boolean isFull() {
        return capacity == used;
    }

    public boolean isEmpty() {
        return used == 0;
    }
}
