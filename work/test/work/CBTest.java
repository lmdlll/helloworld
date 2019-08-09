package work;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class CBTask implements Runnable{
    private CyclicBarrier cyclicBarrier;
    public CBTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"到场");
        try {
            TimeUnit.SECONDS.sleep(2);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("全部到场，会议开始");
    }
}

public class CBTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        CBTask rb = new CBTask(cyclicBarrier);
        new Thread(rb,"小张").start();
        new Thread(rb,"小王").start();
        new Thread(rb,"小李").start();


    }
}
