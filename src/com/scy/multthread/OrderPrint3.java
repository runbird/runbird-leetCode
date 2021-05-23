package com.scy.multthread;

import java.util.concurrent.locks.LockSupport;

/**
 * @desc:
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-05-16 20:28
 **/
public class OrderPrint3 {

    private int loopNum;

    public OrderPrint3(int loopNum) {
        this.loopNum = loopNum;
    }

    private void print(String str, Thread thread) {
        for (int i = 0; i < loopNum; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(thread);
        }
    }

    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) {
        OrderPrint3 order = new OrderPrint3(5);
         t1 = new Thread(() -> {
            order.print("a", t2);
        });
         t2 = new Thread(() -> {
            order.print("b", t3);
        });
         t3 = new Thread(() -> {
            order.print("c", t1);
        });

        t1.start();
        t2.start();
        t3.start();

        LockSupport.unpark(t1);
    }
}
