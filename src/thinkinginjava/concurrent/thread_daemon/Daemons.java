package thinkinginjava.concurrent.thread_daemon;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by seven on 2017/9/6.
 * 后台线程具体介绍：
 * 后台线程创建的子线程都是后台的
 */
public class Daemons {
    public static void main(String[] args) throws Exception{
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon()is="+d.isDaemon());
        TimeUnit.SECONDS.sleep(1);
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

class Daemon implements Runnable {

    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn" + i + "started.");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t["+i+"]isDaemon="+t[i].isDaemon()+".");
        }
        while (true){
            Thread.yield();
        }
    }
}
