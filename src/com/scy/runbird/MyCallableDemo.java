package com.scy.runbird;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 类名： MyCallableDemo <br>
 * 描述：TODO <br>
 * 创建日期： 2021/7/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MyCallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable test");
        TimeUnit.SECONDS.sleep(5);
        return "end";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallableDemo demo = new MyCallableDemo();
        FutureTask<String> task = new FutureTask<>(demo);
        new Thread(task).start();
        if (!task.isDone()) {
            System.out.println("continue....");
        }
        System.out.println("done:"+task.get());
    }
}
