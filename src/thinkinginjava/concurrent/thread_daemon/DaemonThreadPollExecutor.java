package thinkinginjava.concurrent.thread_daemon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by seven on 2017/9/6.
 * 样例代码: 创建新的线程池
 */
public class DaemonThreadPollExecutor extends ThreadPoolExecutor {
    public DaemonThreadPollExecutor() {
//        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        super(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),new DaemonFactory());
    }
}
