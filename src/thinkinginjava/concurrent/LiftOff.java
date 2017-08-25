package thinkinginjava.concurrent;

/**
 * Created by seven on 2017/8/25.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "),";

    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName());
        while (countDown-- >0){
            System.out.print(status());
            Thread.yield();
        }
        System.out.println();
    }
}
