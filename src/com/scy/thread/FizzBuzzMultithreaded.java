package com.scy.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 类名： FizzBuzzMultithreaded <br>
 * 描述：编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 创建日期： 2019/11/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FizzBuzzMultithreaded {

    private volatile int m;
    private volatile int n = 1;
    private Semaphore number = new Semaphore(1);
    private Semaphore fizz = new Semaphore(1);
    private Semaphore buzz = new Semaphore(1);
    private Semaphore fizzbuzz = new Semaphore(1);

    public FizzBuzzMultithreaded(int m) {
        this.m = m;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (n % 3 == 0 && n % 5 != 0) {
            fizz.acquire();
            printFizz.run();
            number.release();
            if (m == n) return;
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (n % 5 == 0 && n % 3 != 0) {
            buzz.acquire();
            printBuzz.run();
            number.release();
            if (m == n) return;
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        if (n % 3 == 0 && n % 5 == 0) {
            fizzbuzz.acquire();
            printFizzBuzz.run();
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        number.acquire();
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 || i % 5 == 0) {
                printNumber.accept(i);
            } else if (i % 3 == 0 && i % 5 != 0){
                fizz.release();
            } else if (i % 5 == 0 && i % 3 != 0) {
                buzz.release();
            }
        }
        return;
    }

    public static void main(String[] args) {
        IntConsumer printNumber = System.out::print;
        FizzBuzzMultithreaded fbm = new FizzBuzzMultithreaded(15);
        try {
            fbm.fizz(()->System.out.print("fizz,"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            fbm.buzz(() -> System.out.print("buzz,"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            fbm.fizzbuzz(() -> System.out.print("fizzbuzz,"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            fbm.number(printNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
