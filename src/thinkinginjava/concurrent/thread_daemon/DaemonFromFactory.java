package thinkinginjava.concurrent.thread_daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by seven on 2017/9/6.
 *
 * ExecutorService构造函数接受ThreadFactory对象(用来创建线程)
 * 通过ThreadFactory将所有线程设置为后台线程
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
//        新建Executor，接受ThreadFactory，工厂方法
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
