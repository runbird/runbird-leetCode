package com.scy.multthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc:
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-05-12 23:12
 **/
public class OrderPrint2 extends ReentrantLock {

    private int loopNum;

    public OrderPrint2(int loopNum) {
        this.loopNum = loopNum;
    }

    private void print(String str, Condition cur, Condition next) {
        for (int i = 0; i < loopNum; i++) {
            lock();
            try {
                cur.await();
                System.out.print(str);
                next.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }

    public static void main(String[] args) {
        OrderPrint2 order = new OrderPrint2(5);
        Condition a = order.newCondition();
        Condition b = order.newCondition();
        Condition c = order.newCondition();

        new Thread(() -> {
            order.print("a", a, b);
        }).start();
        new Thread(() -> {
            order.print("b", b, c);
        }).start();
        new Thread(() -> {
            order.print("c", c, a);
        }).start();

        try {
            Thread.sleep(1000);
            order.lock();
            System.out.println("------- start");
            a.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            order.unlock();
        }
    }
}
