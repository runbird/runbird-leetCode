package com.scy.multthread;

import java.util.concurrent.Semaphore;

/**
 * 类名： PrintInOrder <br>
 * 描述：
 * 我们提供了一个类：
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 创建日期： 2019/10/18 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PrintInOrder2 {

    private Semaphore first = new Semaphore(1);
    private Semaphore second = new Semaphore(0);
    private Semaphore third = new Semaphore(0);

    public PrintInOrder2() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        first.acquire();
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        third.acquire();
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder2 order = new PrintInOrder2();
        new Thread(() -> {
            try {
                order.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                order.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                order.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
