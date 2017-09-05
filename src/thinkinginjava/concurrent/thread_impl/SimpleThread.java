package thinkinginjava.concurrent.thread_impl;

/**
 * Created by seven on 2017/8/25.
 * 多线程实现方法之一继承Thread实现方式
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#"+getName()+"("+countDown+"),";
    }

    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
