package com.scy.thread;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

/**
 * 类名： PrintZeroEvenOdd <br>
 * 描述：假设有这么一个类：
 * <p>
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出："0102030405"
 * <p>
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 创建日期： 2019/10/22 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PrintZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) {
        try {
            for (int i = 0; i < n; i++) {
                zero.acquire();
                printNumber.accept(0);
                // ？ keypoint
                if ((i & 1) == 0) {
                    odd.release();
                } else {
                    even.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void even(IntConsumer printNumber) {
        for (int i = 2; i <= n; i += 2) {
            try {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void odd(IntConsumer printNumber) {
        for (int i = 1; i <= n; i += 2) {
            try {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PrintZeroEvenOdd order = new PrintZeroEvenOdd(6);
        IntConsumer printNumner = System.out::print;
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 20L,
//                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
//        executor.execute(() -> order.zero(printNumner));
//        executor.execute(() -> order.odd(printNumner));
//        executor.execute(() -> order.even(printNumner));
        new Thread(()->order.zero(printNumner)).start();
        new Thread(()->order.odd(printNumner)).start();
        new Thread(()->order.even(printNumner)).start();
    }
}
