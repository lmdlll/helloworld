package work;


import java.util.HashMap;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ECTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        Thread girl = new Thread(()->{
            try {
                String str = exchanger.exchange("我喜欢你");
                System.out.println("女生说:"+str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread boy = new Thread(()->{
            System.out.println("此时，两个年轻人相遇了~");
            try {
                String str  = exchanger.exchange( "我看上你了！");
                System.out.println("男生说:"+str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        girl.start();
        boy.start();
    }
}
