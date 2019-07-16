package work;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

//CountDownLatch练习
class CDLTask implements Runnable{
    CountDownLatch count = new CountDownLatch(3);
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.countDown();
    }
}
public class CDLTest {
    public static void main(String[] args) {
        System.out.println("裁判挥旗，比赛开始");
        Runnable rb = new CDLTask();
        new Thread(rb,"运动员A").start();
        new Thread(rb,"运动员B").start();
        new Thread(rb,"运动员C").start();
        System.out.println("裁判挥旗，比赛结束");


    }

}
