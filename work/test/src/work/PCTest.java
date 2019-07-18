package work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Good{
    private String GoodsName = "macbook";
    private int num = 10;
    private int maxnum = 5;

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    private Lock lock = new ReentrantLock();
    private Condition pro = lock.newCondition();
    private Condition con = lock.newCondition();

    //生产方法
    public void produce() throws Exception{
        try {
            lock.lock();
            while (num==maxnum){
                System.out.println("货还多，还早~~");
                pro.await();
            }
            System.out.println(Thread.currentThread().getName()+"生产"+(this.num++));
            //唤醒消费者
            con.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //消费方法
    public void consume() throws Exception{
        try {
            lock.lock();
            while (num==0){
                System.out.println("没有货了，等一会儿~~");
                pro.await();
            }
            System.out.println(Thread.currentThread().getName()+"消费"+(this.num--));
            //唤醒生产者
            con.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}


class ProduceThread implements Runnable{
    private Good good;
    public ProduceThread(Good good) {
        this.good = good;
    }
    @Override
    public void run() {
        while (true){
            try {
                this.good.produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

class ConsumeThread implements Runnable{
    private Good good;
    public ConsumeThread(Good good) {
        this.good = good;
    }
    @Override
    public void run() {
        while (true){
            try {
                this.good.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



public class PCTest {
    public static void main(String[] args) {
        Good good = new Good();
        ConsumeThread con = new ConsumeThread(good);
        ProduceThread pro = new ProduceThread(good);
        List<Thread> list = new ArrayList<>();
        //生产者线程
        for (int i=0; i<5; i++){
            list.add(new Thread(pro,"生产者"+i));
        }
        //消费者线程
        for(int i=0; i<10; i++){
            list.add(new Thread(con,"消费者"+i));
        }
        for (Thread th:list){
            th.start();
        }

    }
}
