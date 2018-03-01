/**
 * Created on 29/01/2017.
 */

import java.util.concurrent.locks.ReentrantLock;

public class PerformSystemCheck implements Runnable {
    private String checkWhat;
    ReentrantLock lock = new ReentrantLock();

    public PerformSystemCheck(String checkWhat) {
        this.checkWhat = checkWhat;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("Checking " + this.checkWhat);
        lock.unlock();
    }
}
