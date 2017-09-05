package thinkinginjava.concurrent.thread_impl;

import java.util.concurrent.TimeUnit;

/**
 * Created by seven on 2017/8/25.
 * 不同的线程实现方法：内部类
 * 如果需要需要访问创建线程的内部类则需要使用内部类实例，
 * 如不需要(只使用了Thread的能力)，则创建匿名Thread的子类，并将其向上转型为Thread引用t
 *
 * 每个线程的实现方法可以通过Thread或Runnable来实现，两者可以互相替换
 */
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();

    }
}

class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            super.run();
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

        @Override
        public String toString() {
            return getName() + ":" + countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread t;


    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("sleep() interrupted");
                    }
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }
}

class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {

        Thread t;

        public Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(12);
                } catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }
        }

        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}

class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("sleep() interrupted");
                    }
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        }, name);
        t.start();
    }
}

// 在方法内部创建线程，
class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(this);
                            if (--countDown == 0) return;
                            TimeUnit.MILLISECONDS.sleep(11);
                        } catch (InterruptedException e) {
                            System.out.println("sleep() interrupted");
                        }
                    }
                }

                @Override
                public String toString() {
                    return t.getName() + ": " + countDown;
                }
            };
            t.start();
        }
    }
}