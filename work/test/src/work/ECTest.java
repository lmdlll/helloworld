package work;


import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ECTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        Thread girl = new Thread(()->{
            String str = "我喜欢你";
            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("女生说:"+str);
        });

        Thread boy = new Thread(()->{
            System.out.println("此时，两个年轻人相遇了~");
            String str = "我看上你了！";
            try {
               str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("男生说:"+str);

        });

        girl.start();
        boy.start();
    }
}
