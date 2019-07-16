package work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable{
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {

    }
}

public class LockReview {
    public static void main(String[] args) {



    }
}
