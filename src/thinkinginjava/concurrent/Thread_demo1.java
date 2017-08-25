package thinkinginjava.concurrent;

/**
 * Created by seven on 2017/8/25.
 */
public class Thread_demo1 {
    public static void main(String[] args) {
//        mainThread();
//        basicThread();
        morebasicThread();
    }

    //   在main线程创建任务
    public static void mainThread() {
        LiftOff launch = new LiftOff();
        launch.run();
    }

    //    新建一个新的子线程执行任务
    public static void basicThread() {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff");
    }

    public static void morebasicThread() {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
