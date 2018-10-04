package thinkinginjava.concurrent.thread_sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by seven on 2017/9/7.
 * 显式加锁,可以处理异常
 * unlock() 必须在finally中执行,确保unlock()不会过早发生
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield(); // 促发错误发生几率
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
//        return语句执行太晚,导致未传值,但其他任务就已经访问数据并修改其值
//        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}

