package thinkinginjava.concurrent.thread_sync;

/**
 * Created by seven on 2017/9/6.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
