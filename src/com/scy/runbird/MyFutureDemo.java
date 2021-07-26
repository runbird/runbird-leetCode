package com.scy.runbird;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 类名： MyFutureDemo <br>
 * 描述：TODO <br>
 * 创建日期： 2021/7/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MyFutureDemo implements Future<String> {
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public String get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
