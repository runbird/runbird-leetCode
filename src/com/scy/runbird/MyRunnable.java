package com.scy.runbird;

/**
 * 类名： MyRunable <br>
 * 描述：TODO <br>
 * 创建日期： 2021/7/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
