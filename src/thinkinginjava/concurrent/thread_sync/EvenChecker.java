package thinkinginjava.concurrent.thread_sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by seven on 2017/9/6.
 * Checker类通过创建线程同时多次访问同一Generator对象,并进行测试,如果出现失败,就停止该任务并返回
 *
 * 解决资源竞争问题: 一个任务不能依赖另一个任务,因为任务关闭的顺序无法得到保证
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val +" not Even");
                generator.cancel();
            }
        }
    }


//    测试所有的数字生成器
    public static void test(IntGenerator gp, int count){
        System.out.println("test");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
