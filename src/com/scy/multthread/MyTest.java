package com.scy.multthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类名： MyTest <br>
 * 描述：TODO <br>
 * 创建日期： 2021/7/22 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MyTest {
    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int j = 0; j < 6; j++) {
            service.submit(() -> {
                for (int k = 0; k < 2000; k++) {
                    i++;
                   // Thread thread = Thread.currentThread();
                 //   System.out.println(thread.getName() + " " + i);
                }
            });
        }
        Thread thread = Thread.currentThread();
        Thread.sleep(10000);
        System.out.println(thread.getName() + " " + i);
        service.shutdown();
    }
}
