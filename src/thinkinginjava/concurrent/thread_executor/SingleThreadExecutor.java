package thinkinginjava.concurrent.thread_executor;

import thinkinginjava.concurrent.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by seven on 2017/9/5.
 * 单一线程执行器：将任务排队，序列化所有提交给它的任务，并会维护它自己隐藏的悬挂任务队列
 * 可作为事件分发线程，连续运行的任务，使用共享资源
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
