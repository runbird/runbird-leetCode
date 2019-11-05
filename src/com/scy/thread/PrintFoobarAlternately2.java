package com.scy.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 类名： PrintFoobarAlternately <br>
 * 描述：我们提供一个类：
 * class FooBar {
 *  public void foo() {
 *      for (int i = 0; i < n; i++) {
 *          print("foo");
 *      }
 *  }
 *  public void bar() {
 *      for (int i = 0; i < n; i++) {
 *          print("bar");
 *      }
 *  }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * 示例 1:
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 创建日期： 2019/10/18 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PrintFoobarAlternately2 {
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);


    private int n;

    public PrintFoobarAlternately2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) {
        PrintFoobarAlternately2 order = new PrintFoobarAlternately2(10);
        new Thread(() -> {
            try {
                order.foo(() -> System.out.print("foo"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                order.bar(() -> System.out.print("bar"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
