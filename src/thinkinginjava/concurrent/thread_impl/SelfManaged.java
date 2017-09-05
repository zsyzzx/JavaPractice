package thinkinginjava.concurrent.thread_impl;

/**
 * Created by seven on 2017/8/25.
 * 多线程实现方法之二：Runnable,自管理的线程实现方法
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread thread = new Thread(this);

    @Override
    public String toString() {
        return Thread.currentThread().getName() +
                "(" + countDown +
                "),";
    }

    public SelfManaged() {
        thread.start();
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
