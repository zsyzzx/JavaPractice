package thinkinginjava.concurrent.thread_daemon;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by seven on 2017/9/6.
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            不会执行，因为在此之前前台线程已退出，整个程序结束，后台线程也退出
//            若是非后台线程就不会出现这种情况
//            有序的管理线程，使用Executor管理
            System.out.println("Always Run");
        }
    }
}
