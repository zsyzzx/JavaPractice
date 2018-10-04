package thinkinginjava.concurrent.thread_sync;

/**
 * Created by seven on 2017/9/7.
 * synchronized关键字实现了互斥,防止多个任务进入临界区
 * 任何时刻,只有一个任务可以访问有互斥量看护的代码
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();  // 无意义操作,只是为了增加产生失误的机会
        ++currentEvenValue;
        return currentEvenValue;

    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
