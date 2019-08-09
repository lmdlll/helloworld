package work;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Goods{
    //商品名称
    private String name;
    //当前商品数量
    private int count;
    //商品最大数量
    private int maxcount;
    public Goods(int maxcount) {
        this.maxcount = maxcount;
    }
    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();

    //生产方法
    public void setGoods(String name) throws InterruptedException {
        try {
            lock.lock();
            //当商品数量达到最大值时阻塞生产者线程
            while(count==maxcount){
                System.out.println("不急，歇会~~");
                producer.await();
            }
            this.name = name;
            this.count++;
            System.out.println(Thread.currentThread().getName()+"生产"+toString());
            //唤醒消费者线程
            consumer.signalAll();
        }finally {
            lock.unlock();
        }
    }

    //消费方法
    public void getGoods() throws InterruptedException {
        try {
            lock.lock();
            //当商品数量为0时阻塞消费者线程
            while (count==0){
                System.out.println("稍等片刻~~马上生产");
                consumer.await();
            }
            this.count--;
            System.out.println(Thread.currentThread().getName()+"消费"+toString());
            //唤醒生产者方法
            producer.signalAll();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +"name='" + name + '\'' +", count=" + count + '}';
    }
}

class Consumer implements Runnable{
    private Goods goods;
    public Consumer(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        while (true){
            try {
                this.goods.getGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable{
    private Goods goods;
    public Producer(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        while (true){
            try {
                this.goods.setGoods("MAC口红");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PCTest2 {
    public static void main(String[] args) {
        Goods goods = new Goods(20);
        Producer pro = new Producer(goods);
        Consumer con = new Consumer(goods);
        List<Thread> lists = new ArrayList<>();
        //5个生产者模型
        for (int i=0; i<5; i++){
            Thread th = new Thread(pro,"生产者"+i);
            lists.add(th);
        }
        //10个消费者模型
        for (int i=0; i<10; i++){
            Thread th = new Thread(con,"消费者"+i);
            lists.add(th);
        }
        for (Thread thread:lists) {
            thread.start();
        }
    }
}
