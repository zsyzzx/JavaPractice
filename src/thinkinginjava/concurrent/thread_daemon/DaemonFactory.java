package thinkinginjava.concurrent.thread_daemon;

import java.util.concurrent.ThreadFactory;

/**
 * Created by seven on 2017/9/5.
 * 继承ThreadFactory，自定义线程创建策略
 */
public class DaemonFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
//        创建后台线程
        t.setDaemon(true);
        return t;
    }
}
