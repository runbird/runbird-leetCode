package com.scy.algorithm.datastructure.array;

/**
 * @desc:
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-07-17 21:50
 **/
public class Circle {
    private int used = 0;
    private int front = 0;
    private int rear = 0;
    private int capacity = 0;
    private int[] circle = null;

    public Circle(int k) {
        capacity = k;
        this.circle = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        circle[rear] = value;
        rear = (rear + 1) % capacity;
        used++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        int ret = circle[front];
        front = (front + 1) % capacity;
        used --;
        return true;
    }

    public int Rear() {
        if (isEmpty()) return -1;
        // 注意：这里不能使用rear - 1
        // 需要取模 否则 rear = 0 就报错
        int tail = (rear - 1 + capacity) % capacity;
        return circle[tail];
    }

    public int Front() {
        if (isEmpty()) return -1;
        return circle[front];
    }

    private boolean isEmpty() {
        return used == 0;
    }

    private boolean isFull() {
        return used == capacity;
    }

// 采用非满队列
//    public boolean isFull() {
//        // rear与front之间至少有一个空格
//        // 当rear指向这个最后的一个空格时，
//        // 队列就已经放满了!
//        return (rear + 1) % capacity == front;
//    }

    public static void main(String[] args) {
        String str = "abcdef";
        int num = 0;
        for (char c : str.toCharArray()) {
            int idx = c - 'a' + 1;
            while (idx != 0) {
                num += idx %10;
                idx /= 10;
            }
        }
        System.out.println(num);
    }
}
