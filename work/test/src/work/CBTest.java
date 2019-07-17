package work;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CBTask implements Runnable{
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"到场");
        try {
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
        Runnable rb = new CBTask();
        new Thread(rb,"小张").start();
        new Thread(rb,"小王").start();
        new Thread(rb,"小李").start();


    }
}
