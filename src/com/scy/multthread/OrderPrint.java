package com.scy.multthread;

/**
 * @desc:
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-05-10 00:17
 **/
public class OrderPrint {

    private int flag;
    private int loopNumber;

    public OrderPrint(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

//    private void print(String owner, int excpetNumber, int nextNum) {
//        for (int i = 0; i < loopNumber; i++) {
//            synchronized (this) {
//                while (flag != excpetNumber) {
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.print(owner);
//                flag = nextNum;
//                this.notifyAll();
//            }
//        }
//    }

    private void print(String owner, int excpetNumber, int nextNum) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                if (flag != excpetNumber) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(owner);
                    flag = nextNum;
                    this.notifyAll();
                }
            }
        }
    }

        public static void main (String[]args){
            OrderPrint order = new OrderPrint(1, 5);
            new Thread(() -> {
                order.print("a",1,2);
            }).start();
            new Thread(() -> {
                order.print("b",2,3);
            }).start();
            new Thread(() -> {
                order.print("c",3,1);
            }).start();
        }
    }
