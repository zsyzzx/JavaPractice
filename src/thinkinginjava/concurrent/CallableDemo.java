package thinkinginjava.concurrent;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by seven on 2017/9/5.
 * 具有返回值的线程操作
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
//            用executor的submit()方法执行Callable对象,返回一个Future对象，内容贮存在Future对象中
//            通过get()获取内容，isDone()方法判断Future是否已经完成，
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs :
                results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "thread" +Thread.currentThread().getName()+","+
                "result of TaskWithResult" + id;
    }
}
