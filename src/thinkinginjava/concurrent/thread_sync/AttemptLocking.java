package thinkinginjava.concurrent.thread_sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 显示加锁，控制共享资源的访问
 * Java编程思想中的源码 新家线程获取锁，主线程无法获取到锁，访问资源
 *  遇到问题 使用1.8JDK
 *  书中源码: 新建线程的启动时机不对，程序结束全部语句再启动线程
 *  解决方法: 执行线程启动语句后(start())，将主线程睡眠(sleep(2000))，等待子线程执行完后，在进行下一步
 *  可能导致的原因: Jdk版本不一样，导致编译结果优化的语句顺序不一样，即顺序执行完所有与线程无关的语句，再建立子线程进行操作
 *  也有可能是 机器原因，系统调度线程的方法，启动时间不一致导致的
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():" + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2) : " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking attemptLocking = new AttemptLocking();

//        新建线程，但执行顺序不符合预期
//        Thread test = new Thread() {
//            @Override
//            public void run() {
//                attemptLocking.lock.lock();
//                System.out.println("Acquired");
////                attemptLocking.lock.unlock();
//            }
//        };
//        test.setDaemon(true);
//        test.start();

//        一个任务执行，能够获取到锁
        attemptLocking.untimed();
        attemptLocking.timed();


//        新建线程，相当于两个任务访问同一资源
        new Thread(){
            {setDaemon(true);}

            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println("Acquired");

            }
        }.start();

//        Thread.yield();  //进入并执行新建立的线程
//        让新建线程顺利进行后再进入主线程
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attemptLocking.untimed();
        attemptLocking.timed();
    }
}
