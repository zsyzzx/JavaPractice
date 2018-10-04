package thinkinginjava.concurrent.thread_sync;

/**
 * Created by seven on 2017/9/7.
 * 该类线程不安全
 * 解决方法: 实现线程安全
 * 互斥区方法,手动加锁{@link MutexEvenGenerator}, synchronized关键字方法{@link SynchronizedEvenGenerator}
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
