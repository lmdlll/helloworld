package work;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

//CountDownLatch练习
class CDLTask implements Runnable{
    private CountDownLatch count;
    public CDLTask(CountDownLatch count) {
        this.count = count;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"到达终点");
        count.countDown();
    }
}
public class CDLTest {
    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(3);
        System.out.println("裁判挥旗，比赛开始");
        Runnable rb = new CDLTask(count);
        new Thread(rb,"运动员A").start();
        new Thread(rb,"运动员B").start();
        new Thread(rb,"运动员C").start();
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("裁判挥旗，比赛结束");

    }

}
